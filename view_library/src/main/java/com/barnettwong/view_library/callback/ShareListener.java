package com.barnettwong.view_library.callback;



/**
 * 分享回调
 */

public interface ShareListener {

    public abstract void shareSuccess();

    public abstract void shareFailure(Exception e);

    public abstract void shareCancel();

}
