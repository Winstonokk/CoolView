package com.barnettwong.coolview.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.barnettwong.coolview.R;
import com.barnettwong.view_library.view.WaterMark;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wang on 2019/1/18 14:43
 */
public class WaterMarkActivity extends BaseActivity {


    @BindView(R.id.ll_content)
    LinearLayout llContent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_watermark;
    }

    @Override
    public void initView() {
        String content="wangfeng19930909";
        WaterMark waterMark = new WaterMark.Builder(WaterMarkActivity.this)
                .setContent(content)//自定义水印内容，也可以去掉使用默认
                .build();
        llContent.setBackground(waterMark.getBitmapDrawable());
    }

}
