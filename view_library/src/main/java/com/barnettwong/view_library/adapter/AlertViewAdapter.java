package com.barnettwong.view_library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.barnettwong.view_library.R;

import java.util.List;

/**
 * Created by wang on 2018/8/8.
 **/
public class AlertViewAdapter extends BaseAdapter {
    private List<String> mDatas;
    private List<String> mDestructive;

    public AlertViewAdapter(List<String> datas, List<String> destructive) {
        this.mDatas = datas;
        this.mDestructive = destructive;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String data = mDatas.get(position);
        Holder holder = null;
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.item_alertbutton, null);
            holder = creatHolder(view);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.UpdateUI(parent.getContext(), data, position);

        if (mDatas.size() >= 3) {
            if (position == 2) {
                holder.tvAlert.setTextColor(0xffEB7E7E);
            }
        }

        return view;
    }

    public Holder creatHolder(View view) {
        return new Holder(view);
    }

    class Holder {
        private TextView tvAlert;
        private View view;

        public Holder(View view) {
            tvAlert = (TextView) view.findViewById(R.id.tvAlert);
            this.view = (View) view.findViewById(R.id.view);
        }

        public void UpdateUI(Context context, String data, int position) {
            tvAlert.setText(data);
            if (position == 0) {
                this.view.setVisibility(View.GONE);
            }
            if (mDestructive != null && mDestructive.contains(data)) {
                tvAlert.setTextColor(context.getResources().getColor(
                        R.color.textColor_alert_button_others));
            } else {
                tvAlert.setTextColor(context.getResources().getColor(
                        R.color.textColor_alert_button_others));
            }

        }
    }
}

