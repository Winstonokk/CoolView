package com.barnettwong.coolview.activity;

import android.view.View;
import android.widget.Button;

import com.barnettwong.coolview.R;
import com.barnettwong.view_library.view.ShareBottomDialog;

import butterknife.BindView;

/**
 * Created by wang on 2019/1/22 17:58
 */
public class ShareBottomDialogActivity extends BaseActivity {
    @BindView(R.id.btn_share)
    Button btnShare;

    @Override
    public int getLayoutId() {
        return R.layout.activity_share_bottom_dialog;
    }

    @Override
    public void initView() {
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareBottomDialog dialog = new ShareBottomDialog();
                dialog.show(getSupportFragmentManager());
            }
        });


    }

}
