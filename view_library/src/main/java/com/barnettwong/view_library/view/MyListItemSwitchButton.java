package com.barnettwong.view_library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.barnettwong.view_library.R;


/**
 * Created by tiankui on 7/6/17.
 */

public class MyListItemSwitchButton extends LinearLayout {
    private MySwitchButton switchButton;

    public MyListItemSwitchButton(Context context) {
        super(context);
        initView(null);
    }

    public MyListItemSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        inflate(getContext(), R.layout.switch_button_list_item, this);
        switchButton = (MySwitchButton) findViewById(R.id.switch_button);
        TextView rce_list_item_title = (TextView) findViewById(R.id.tv_title);
        if (attrs != null) {
            TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.swb_list_item);
            CharSequence title = attributes.getText(R.styleable.swb_list_item_swb_list_item_title);
            rce_list_item_title.setText(title);
            attributes.recycle();
        }
    }

    public void setSwitchButtonChangedListener(CompoundButton.OnCheckedChangeListener checkedChangeListener) {
        switchButton.setOnCheckedChangeListener(checkedChangeListener);
    }

    public void setChecked(boolean checked){
        switchButton.setChecked(checked);
    }

    public boolean isChecked(){
        return switchButton.isChecked();
    }

    public void setCheckedImmediately(boolean checked){
        switchButton.setCheckedImmediately(checked);
    }
}
