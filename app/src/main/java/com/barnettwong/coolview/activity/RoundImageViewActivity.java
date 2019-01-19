package com.barnettwong.coolview.activity;

import android.view.View;

import com.barnettwong.coolview.R;
import com.barnettwong.view_library.view.RoundImageView;

import butterknife.BindView;

/**
 * Created by wang on 2019/1/19 15:41
 */
public class RoundImageViewActivity extends BaseActivity {
    @BindView(R.id.id_qiqiu)
    RoundImageView mQiQiu;
    @BindView(R.id.id_meinv)
    RoundImageView mMeiNv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_roundimageview;
    }

    @Override
    public void initView() {
//        mQiQiu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mQiQiu.setType(RoundImageView.TYPE_ROUND);
//            }
//        });
//
//        mMeiNv.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                mMeiNv.setBorderRadius(90);
//            }
//        });

    }


}
