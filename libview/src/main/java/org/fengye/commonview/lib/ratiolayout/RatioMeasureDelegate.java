package org.fengye.commonview.lib.ratiolayout;

/**
 * author : caohao
 * date : 2021-03-08 13:18
 * description :
 */
public interface RatioMeasureDelegate {

    void setRatio(RatioDatumMode mode, float datumWidth, float datumHeight);

    void setSquare(boolean square);

    void setAspectRatio(float aspectRatio);
}