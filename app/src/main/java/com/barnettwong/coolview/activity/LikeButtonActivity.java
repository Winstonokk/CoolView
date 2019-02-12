package com.barnettwong.coolview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.barnettwong.coolview.R;
import com.barnettwong.view_library.view.likebutton.LikeButton;
import com.barnettwong.view_library.view.likebutton.OnLikeListener;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wang on 2019/1/18 14:43
 */
public class LikeButtonActivity extends BaseActivity implements OnLikeListener, View.OnClickListener{


    @BindView(R.id.heart_button)
    LikeButton heartButton;
    @BindView(R.id.thumb_button)
    LikeButton thumbButton;
    @BindView(R.id.btn_text_likebutton)
    Button btnTextLikebutton;

    //    点击的次数
    private   long  clickcounts=0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_likebutton;
    }

    @Override
    public void initView() {
        heartButton.setOnLikeListener(this);
        thumbButton.setOnLikeListener(this);
        btnTextLikebutton.setOnClickListener(this);
    }

    @Override
    public void liked(LikeButton likeButton)
    {

        int  btn_id=likeButton.getId();
        switch (btn_id){
            case  R.id.heart_button:
                ToastUtils.showShort("关注");
                break;

            case  R.id.thumb_button:
                ToastUtils.showShort("点赞");

                break;

        }
    }

    @Override
    public void unLiked(LikeButton likeButton) {

        int  btn_id=likeButton.getId();
        switch (btn_id){
            case  R.id.heart_button:
                ToastUtils.showShort("取消关注");
                break;

            case  R.id.thumb_button:
                ToastUtils.showShort("取消点赞");

                break;

        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case  R.id.btn_text_likebutton:
                clickcounts++;

                if (clickcounts%2==0){
                    ToastUtils.showShort("普通按钮--  喜欢");
                    btnTextLikebutton.setText(clickcounts+"  喜欢");
                }else {
                    ToastUtils.showShort("普通按钮--  不喜欢");
                    btnTextLikebutton.setText(clickcounts+"  不喜欢");

                }

                break;
        }

    }

}
