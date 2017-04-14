package com.yotuhink.recylcerviewexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.yotuhink.recylcerviewexample.R;
import com.yotuhink.recylcerviewexample.vo.Photo;

import java.util.ArrayList;

/**
 * Created by Youthink on 2017-04-14.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<Photo> photoList;
    private int itemLayout;
    private Context context;

    /**
     * RecyclerAdapter 생성자
     * */
    public RecyclerAdapter(ArrayList<Photo> photoList, int itemLayout, Context context) {
        this.photoList = photoList;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    /**
     * Layout 을 ViewHolder 에 저장
     * */
    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Photo photo = photoList.get(position);

        Glide.with(context)
                .load(photo.getImage())
                .into(holder.image);

        holder.name.setText(photo.getName());
    }

    /**
     * List의 크기
     * */
    @Override public int getItemCount() {
        return photoList.size();
    }

    /**
     * View 재활용을 위한 ViewHolder
     * */
    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.imageName);
        }
    }
}
