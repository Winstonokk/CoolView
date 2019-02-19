package com.barnettwong.coolview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.barnettwong.coolview.R;
import com.barnettwong.view_library.view.LoadingDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wang on 2019/1/18 14:43
 */
public class LoadingDialogActivity extends BaseActivity {


    @BindView(R.id.btn_show)
    Button btnShow;

    private LoadingDialog mLoadingDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_loadingdialog;
    }

    @Override
    public void initView() {
        mLoadingDialog=LoadingDialog.create(this).setDetailLabel("正在加载...");
        mLoadingDialog.setCancellable(true);
        MyOnClickListener onClickListener=new MyOnClickListener();
        btnShow.setOnClickListener(onClickListener);
    }

    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_show:
                    mLoadingDialog.show();
                    break;
            }
        }
    }

}
