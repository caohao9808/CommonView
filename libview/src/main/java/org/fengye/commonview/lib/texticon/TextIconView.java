package org.fengye.commonview.lib.texticon;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

import org.fengye.commonview.lib.R;
import org.fengye.commonview.lib.util.Util;


public class TextIconView extends AppCompatTextView {

    private ColorStateList tintColor;
    private Drawable icon;

    private int iconSize;

    private int iconWidth;
    private int iconHeight;

    private int iconPosition;


    public TextIconView(@NonNull Context context) {
        super(context);
    }

    public TextIconView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextIconView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextIconView);

        icon = typedArray.getDrawable(R.styleable.TextIconView_icon);

        iconPosition = typedArray.getInt(R.styleable.TextIconView_iconPosition, 1);

        tintColor = typedArray.getColorStateList(R.styleable.TextIconView_tintColor);

        iconSize = typedArray.getDimensionPixelSize(R.styleable.TextIconView_iconSize, Util.dp2px(context, 14f));
        iconWidth = typedArray.getDimensionPixelSize(R.styleable.TextIconView_iconWidth, iconSize);
        iconHeight = typedArray.getDimensionPixelSize(R.styleable.TextIconView_iconHeight, iconSize);

        typedArray.recycle();

        init();
    }


    private void init() {
//        binding = ViewItemTagBinding.inflate(LayoutInflater.from(getContext()));

//        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        layoutParams.gravity = Gravity.CENTER;
//        addView(binding.getRoot(), layoutParams);

//        int size = ConvertUtils.dp2px(14f);

        if (iconWidth > 0 && iconHeight > 0) {
            icon.setBounds(0, 0, iconWidth, iconHeight);
        } else {
            icon.setBounds(0, 0, iconSize, iconSize);
        }


        if (tintColor != null) {
            TextViewCompat.setCompoundDrawableTintList(this, tintColor);
        }


        if (iconPosition == 2) {
            setCompoundDrawables(null, null, icon, null);
        } else if (iconPosition == 3) {
            setCompoundDrawables(null, null, null, icon);
        } else if (iconPosition == 4) {
            setCompoundDrawables(icon, null, null, null);
        } else {
            setCompoundDrawables(null, icon, null, null);
        }

//        setGravity(Gravity.CENTER);

//        if (textColor != null) {
//            setTextColor(textColor);
//        } else if (tintColor != null) {
//            setTextColor(tintColor);
//        }
    }
}
