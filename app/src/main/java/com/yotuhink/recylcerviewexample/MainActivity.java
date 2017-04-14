package com.yotuhink.recylcerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.yotuhink.recylcerviewexample.vo.Photo;
import com.yotuhink.recylcerviewexample.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<Photo> photoArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Button linear = (Button) findViewById(R.id.linearLayout);
        Button grid = (Button) findViewById(R.id.gridLayout);
        Button staggered = (Button) findViewById(R.id.staggeredGridLayout);

        initData();

        linear.setOnClickListener(this);
        grid.setOnClickListener(this);
        staggered.setOnClickListener(this);
    }

    @Override public void onClick(View view) {
        if (view.getId() == R.id.linearLayout) {
            RecyclerAdapter adapter = new RecyclerAdapter(photoArrayList, R.layout.row, this);
            LinearLayoutManager manager = new LinearLayoutManager(this);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
        } else if (view.getId() == R.id.gridLayout) {
            RecyclerAdapter adapter = new RecyclerAdapter(photoArrayList, R.layout.row, this);
            GridLayoutManager manager = new GridLayoutManager(this, 3);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
        } else if (view.getId() == R.id.staggeredGridLayout) {
            RecyclerAdapter adapter = new RecyclerAdapter(photoArrayList, R.layout.row, this);
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
        }
    }

    private void initData() {
        photoArrayList.add(new Photo(R.drawable.people, "아이린"));
        photoArrayList.add(new Photo(R.drawable.people2, "슬기"));
        photoArrayList.add(new Photo(R.drawable.people3, "김세정"));
        photoArrayList.add(new Photo(R.drawable.people4, "정연"));
        photoArrayList.add(new Photo(R.drawable.people5, "설현"));
        photoArrayList.add(new Photo(R.drawable.people6, "쯔위"));

        RecyclerAdapter adapter = new RecyclerAdapter(photoArrayList, R.layout.row, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}
