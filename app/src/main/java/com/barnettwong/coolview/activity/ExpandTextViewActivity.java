package com.barnettwong.coolview.activity;

import com.barnettwong.coolview.R;
import com.barnettwong.view_library.view.ExpandableTextView;

import butterknife.BindView;

/**
 * Created by wang on 2019/1/18 14:43
 */
public class ExpandTextViewActivity extends BaseActivity {


    @BindView(R.id.expandable_textview)
    ExpandableTextView expandableTextview;

    @Override
    public int getLayoutId() {
        return R.layout.activity_expandtextview;
    }

    @Override
    public void initView() {
        expandableTextview.setText("团战人都没来齐，打的什么鬼玩意啊，你们这些人真的不配赢，我最不喜欢骂人的，可是这种水平劝你们尽早戒掉游戏，祸害自己也祸害他人，难怪还是白银段位啊啊啊啊啊啊");
    }

}
