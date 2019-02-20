package com.barnettwong.coolview.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.barnettwong.coolview.R;
import com.barnettwong.coolview.adapter.ViewAdapter;
import com.barnettwong.coolview.callback.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ViewAdapter viewAdapter;
    private List<String> viewNames;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initData();
        viewAdapter = new ViewAdapter(MainActivity.this, viewNames);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setAdapter(viewAdapter);
        initListener();
    }

    private void initListener() {
        viewAdapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                switch (position) {
                    case 0://拓展的textview
                        startActivity(ExpandTextViewActivity.class);
                        break;
                    case 1://AlertView
                        startActivity(AlertViewActivity.class);
                        break;
                    case 2://不可滑动的viewPager
                        startActivity(NoScrollViewPagerActivity.class);
                        break;
                    case 3://自己动手实现圆形，圆角图片
                        startActivity(RoundImageViewActivity.class);
                        break;
                    case 4://表情键盘
                        startActivity(EmojiKeyboardActivity.class);
                        break;
                    case 5://底部分享dialog自定义
                        startActivity(ShareBottomDialogActivity.class);
                        break;
                    case 6://点赞
                        startActivity(LikeButtonActivity.class);
                        break;
                    case 7://加载框
                        startActivity(LoadingDialogActivity.class);
                        break;
                    case 8://水印
                        startActivity(WaterMarkActivity.class);
                        break;
                }
            }
        });
    }

    private void initData() {
        viewNames = new ArrayList<>();
        viewNames.add("可拓展可收缩的ExpandTextView");
        viewNames.add("高仿ios的底部多类型菜单AlertView");
        viewNames.add("不可滑动的viewPager");
        viewNames.add("自己动手实现圆形，圆角图片");
        viewNames.add("表情键盘");
        viewNames.add("第三方分享底部dialog自定义");
        viewNames.add("点赞效果");
        viewNames.add("加载框自定义");
        viewNames.add("水印背景生成");
    }


}
