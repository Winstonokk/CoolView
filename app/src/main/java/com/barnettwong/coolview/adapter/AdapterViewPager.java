package com.barnettwong.coolview.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;


import com.barnettwong.coolview.fragment.BaseFragment;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by wang on 2018/8/9.
 **/
public class AdapterViewPager extends FragmentStatePagerAdapter {
    private List<BaseFragment> list;
    private CharSequence[] mTitles;
    private List<String> titleList;

    public AdapterViewPager(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void bindData(List<BaseFragment> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void bindData(List<BaseFragment> list, CharSequence[] titles) {
        this.list = list;
        this.mTitles = titles;
        notifyDataSetChanged();
    }

    public void bindData(List<BaseFragment> list, List<String> titleList) {
        this.list = list;
        this.titleList = titleList;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null) {
            return mTitles[position];
        } else if (titleList != null) {
            return titleList.get(position);
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment f = (Fragment) super.instantiateItem(container, position);
        View view = f.getView();
        if (view != null)
            container.addView(view);
        return f;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = list.get(position).getView();
        if (view != null)
            container.removeView(view);
    }

    public static void setIndicator(Context context, TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) (getDisplayMetrics(context).density * leftDip);
        int right = (int) (getDisplayMetrics(context).density * rightDip);

        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            View child = ll_tab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(
                Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(
                displaymetrics);
        return displaymetrics;
    }

}

