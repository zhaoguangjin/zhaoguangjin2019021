package com.example.zh.zhaoguangjin20190218.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zh.zhaoguangjin20190218.R;
import com.example.zh.zhaoguangjin20190218.bean.Bean;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.VVH> {
    Context context;
    List<Bean.DataBeanX.DataBean> beans;
    LayoutInflater layoutInflater;

    public Adapter(Context context, List<Bean.DataBeanX.DataBean> beans) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public VVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.layout, viewGroup, false);
        VVH vvh = new VVH(view);
        return vvh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.VVH vvh, int i) {
        vvh.text.setText(beans.get(i).getTitle());
        Glide.with(context).load("http://365jia.cn/uploads/appletrecommend/201804/5ad6ba6c6bb8b.jpg").into(vvh.img);
    }


    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class VVH extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView text;

        public VVH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.reimg);
            text = itemView.findViewById(R.id.retext);
        }
    }
}
