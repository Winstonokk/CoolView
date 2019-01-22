package com.barnettwong.view_library.view;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;


import com.barnettwong.view_library.R;
import com.barnettwong.view_library.callback.ShareListener;
import com.blankj.utilcode.util.ToastUtils;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by wang on 2018/08/10.
 */
public class ShareBottomDialog extends BaseBottomDialog implements View.OnClickListener {

    private ShareListener mShareListener;

    @Override
    public int getLayoutRes() {
        return R.layout.layout_bottom_share;
    }

    @Override
    public void bindView(final View v) {
        v.findViewById(R.id.share_qq).setOnClickListener(this);
        v.findViewById(R.id.share_qzone).setOnClickListener(this);
        v.findViewById(R.id.share_weibo).setOnClickListener(this);
        v.findViewById(R.id.share_wx).setOnClickListener(this);
        v.findViewById(R.id.share_wx_timeline).setOnClickListener(this);
        v.findViewById(R.id.rl_cancle).setOnClickListener(this);

        mShareListener = new ShareListener() {

            @Override
            public void shareSuccess() {
                Toast.makeText(v.getContext(), "分享成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void shareFailure(Exception e) {
                Toast.makeText(v.getContext(), "分享失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void shareCancel() {
                Toast.makeText(v.getContext(), "取消分享", Toast.LENGTH_SHORT).show();

            }
        };
    }

    @Override
    public void onClick(View v) {
        int rId=v.getId();
        if(rId==R.id.share_qq){
            ToastUtils.showShort("分享到QQ");
        }else if(rId==R.id.share_qzone){
            ToastUtils.showShort("分享到QQ空间");
        }else if(rId==R.id.share_weibo){
            ToastUtils.showShort("分享到微博");
        }else if(rId==R.id.share_wx){
            ToastUtils.showShort("分享到微信");
        }else if(rId==R.id.share_wx_timeline){
            ToastUtils.showShort("分享到微信朋友圈");
        }
        dismiss();
    }

    @Override
    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager);
    }
}
