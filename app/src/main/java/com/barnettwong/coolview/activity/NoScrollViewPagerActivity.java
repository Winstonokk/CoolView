package com.barnettwong.coolview.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.barnettwong.coolview.R;
import com.barnettwong.coolview.adapter.AdapterViewPager;
import com.barnettwong.coolview.bean.TabEntity;
import com.barnettwong.coolview.fragment.BaseFragment;
import com.barnettwong.view_library.view.NoScrollViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wang on 2019/1/19 14:51
 */
public class NoScrollViewPagerActivity extends BaseActivity {
    @BindView(R.id.viewpager)
    NoScrollViewPager viewPager;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;

    private AdapterViewPager adapter;
    private List<BaseFragment> fragmentList;

    private String[] mTitles ;
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal, R.mipmap.ic_care_normal,R.mipmap.ic_girl_normal, R.mipmap.ic_mine_unselect,};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected, R.mipmap.ic_care_selected, R.mipmap.ic_girl_selected,R.mipmap.ic_mine_select,};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private BaseFragment mHomeFragment;
    private BaseFragment mCareFragment;
    private BaseFragment mGirlFragment;
    private BaseFragment mMineFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_noscrollviewpager;
    }

    @Override
    public void initView() {
        //初始化菜单
        initTab();
        //初始化frament
        initFragment();
        initViewPager();
    }

    /**
     * 初始化tab
     */
    private void initTab() {
        mTitles=getResources().getStringArray(R.array.tab_type);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tab_layout);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position,false);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        tabLayout.measure(0, 0);
    }

    /**
     * 初始化碎片
     */
    private void initFragment() {
        Bundle bundle1 = new Bundle();
        bundle1.putString("mContent", "首页");
        Bundle bundle2 = new Bundle();
        bundle2.putString("mContent", "看点");
        Bundle bundle3 = new Bundle();
        bundle3.putString("mContent", "美女");
        Bundle bundle4 = new Bundle();
        bundle4.putString("mContent", "我的");
        mHomeFragment=new BaseFragment();
        mHomeFragment.setArguments(bundle1);
        mCareFragment =new BaseFragment();
        mCareFragment.setArguments(bundle2);
        mGirlFragment=new BaseFragment();
        mGirlFragment.setArguments(bundle3);
        mMineFragment =new BaseFragment();
        mMineFragment.setArguments(bundle4);

        fragmentList = new ArrayList<>();
        fragmentList.add(mHomeFragment);
        fragmentList.add(mCareFragment);
        fragmentList.add(mGirlFragment);
        fragmentList.add(mMineFragment);
    }

    private void initViewPager() {
        viewPager.setOffscreenPageLimit(4);
        adapter = new AdapterViewPager(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        adapter.bindData(fragmentList);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                return;
            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //默认显示首页
        int currentTabPosition = 0;
        viewPager.setCurrentItem(currentTabPosition,false);
        tabLayout.setCurrentTab(currentTabPosition);
    }


}
