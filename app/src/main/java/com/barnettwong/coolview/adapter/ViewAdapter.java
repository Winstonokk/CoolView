package com.barnettwong.coolview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.barnettwong.coolview.R;
import com.barnettwong.coolview.callback.ItemClickListener;

import java.util.List;

/**
 * Created by wang on 2019/1/18 14:59
 */
public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> viewNames;
    private ItemClickListener itemClickListener;

    public ViewAdapter(Context mContext, List<String> viewNames) {
        this.mContext = mContext;
        this.viewNames = viewNames;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_view_type,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.tvName.setText(viewNames.get(i));
        myViewHolder.rlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClickListener(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        if((null==viewNames)||(viewNames.size()==0)){
            return 0;
        }else{
            return viewNames.size();
        }
    }

     class MyViewHolder extends RecyclerView.ViewHolder{
         RelativeLayout rlRoot;
         TextView tvName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rlRoot=itemView.findViewById(R.id.rl_root);
            tvName=itemView.findViewById(R.id.tv_name);
        }
    }


}
