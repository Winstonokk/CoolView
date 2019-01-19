package com.barnettwong.coolview.activity;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.barnettwong.coolview.R;
import com.barnettwong.view_library.view.AlertView;

import butterknife.BindView;

/**
 * Created by wang on 2019/1/18 14:43
 */
public class AlertViewActivity extends BaseActivity {
    @BindView(R.id.btn_show)
    Button btnShow;

    private AlertView alertView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_alertview;
    }

    @Override
    public void initView() {
        comfireImgSelection(AlertViewActivity.this);
        alertView.show();
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alertView.isShowing()){
                    alertView.dismiss();
                }else{
                    alertView.show();
                }
            }
        });
    }

    // 拍照
    public void comfireImgSelection(final Context context) {
       alertView= new AlertView(null, null, "取消", null, new String[]{"从手机相册选择", "拍照"}, this, AlertView.Style.ActionSheet,
                (o, position) -> {
                    if (position == 0) {
                        Toast.makeText(context, "相册", Toast.LENGTH_SHORT).show();
                    } else if (position == 1) {
                        Toast.makeText(context, "拍照", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
