package org.fengye.commonview.lib.ratiolayout;

/**
 * author : caohao
 * date : 2021-03-08 13:17
 * description :
 */
public enum RatioDatumMode {
    DATUM_AUTO(0),
    DATUM_WIDTH(1),
    DATUM_HEIGHT(2);

    final int mode;

    RatioDatumMode(int mode) {
        this.mode = mode;
    }

    public static RatioDatumMode valueOf(int mode) {
        if (mode == DATUM_WIDTH.mode) {
            return DATUM_WIDTH;
        }
        if (mode == DATUM_HEIGHT.mode) {
            return DATUM_HEIGHT;
        }
        return DATUM_AUTO;
    }
}
