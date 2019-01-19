package com.barnettwong.coolview.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.barnettwong.coolview.R;

/**
 * Created by wang on 2019/1/19 15:03
 */
public class BaseFragment extends Fragment {
    private  String mContent;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_base,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        if (getArguments() != null) {
            mContent = getArguments().getString("mContent");
        }
        TextView tvContent=view.findViewById(R.id.tv_content);
        tvContent.setText(mContent);
    }
}
