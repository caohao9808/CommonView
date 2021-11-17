package org.fengye.commonview.lib.ratiolayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import org.fengye.commonview.lib.R;
import org.fengye.commonview.lib.ratiolayout.RatioDatumMode;
import org.fengye.commonview.lib.ratiolayout.RatioLayoutDelegate;
import org.fengye.commonview.lib.ratiolayout.RatioMeasureDelegate;


/**
 * author : caohao
 * date : 2021-03-03 8:42
 * description : 自定义Imageview宽高比
 */
public class RatioImageView extends AppCompatImageView implements RatioMeasureDelegate {

    float width, height;

    private float defaultRadius = 0;
    private float radius;
    private float leftTopRadius;
    private float rightTopRadius;
    private float rightBottomRadius;
    private float leftBottomRadius;


    private RatioLayoutDelegate mRatioLayoutDelegate;

    public RatioImageView(Context context) {
        super(context);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRatioLayoutDelegate = RatioLayoutDelegate.obtain(this, attrs);
        initCorner(context, attrs);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRatioLayoutDelegate = RatioLayoutDelegate.obtain(this, attrs, defStyleAttr);
        initCorner(context, attrs);
    }

    private void initCorner(Context context, AttributeSet attrs) {
        // 读取配置
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        radius = array.getDimension(R.styleable.RatioImageView_radius, defaultRadius);
        leftTopRadius = array.getDimension(R.styleable.RatioImageView_left_top_radius, defaultRadius);
        rightTopRadius = array.getDimension(R.styleable.RatioImageView_right_top_radius, defaultRadius);
        rightBottomRadius = array.getDimension(R.styleable.RatioImageView_right_bottom_radius, defaultRadius);
        leftBottomRadius = array.getDimension(R.styleable.RatioImageView_left_bottom_radius, defaultRadius);


        //如果四个角的值没有设置，那么就使用通用的radius的值。
        if (defaultRadius == leftTopRadius) {
            leftTopRadius = radius;
        }
        if (defaultRadius == rightTopRadius) {
            rightTopRadius = radius;
        }
        if (defaultRadius == rightBottomRadius) {
            rightBottomRadius = radius;
        }
        if (defaultRadius == leftBottomRadius) {
            leftBottomRadius = radius;
        }
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.update(widthMeasureSpec, heightMeasureSpec);
            widthMeasureSpec = mRatioLayoutDelegate.getWidthMeasureSpec();
            heightMeasureSpec = mRatioLayoutDelegate.getHeightMeasureSpec();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //这里做下判断，只有图片的宽高大于设置的圆角距离的时候才进行裁剪
        float maxLeft = Math.max(leftTopRadius, leftBottomRadius);
        float maxRight = Math.max(rightTopRadius, rightBottomRadius);
        float minWidth = maxLeft + maxRight;
        float maxTop = Math.max(leftTopRadius, rightTopRadius);
        float maxBottom = Math.max(leftBottomRadius, rightBottomRadius);
        float minHeight = maxTop + maxBottom;
        if (width >= minWidth && height > minHeight) {
            Path path = new Path();
            //四个角：右上，右下，左下，左上
            path.moveTo(leftTopRadius, 0);
            path.lineTo(width - rightTopRadius, 0);
            path.quadTo(width, 0, width, rightTopRadius);

            path.lineTo(width, height - rightBottomRadius);
            path.quadTo(width, height, width - rightBottomRadius, height);

            path.lineTo(leftBottomRadius, height);
            path.quadTo(0, height, 0, height - leftBottomRadius);

            path.lineTo(0, leftTopRadius);
            path.quadTo(0, 0, leftTopRadius, 0);

            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }


    @Override
    public void setSquare(boolean square) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setSquare(square);
        }
    }

    @Override
    public void setAspectRatio(float aspectRatio) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setAspectRatio(aspectRatio);
        }
    }

    @Override
    public void setRatio(RatioDatumMode mode, float datumWidth, float datumHeight) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setRatio(mode, datumWidth, datumHeight);
        }
    }
}