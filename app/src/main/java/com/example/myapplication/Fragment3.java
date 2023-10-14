package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class Fragment3 extends Fragment{   //继承自Fragment类的Fragment3类。在该类中，重写了onCreateView方法用于创建视图
    private RecyclerView recyclerView;
    private List<String> list= new ArrayList<>();
    private Context context;
    private Myadapter myadapter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.tab3,container,false);
        context=view.getContext();
        recyclerView=view.findViewById(R.id.recycleview);
        list=new ArrayList();

        initial();
        myadapter = new Myadapter(context,list);
        recyclerView.setAdapter(myadapter);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        return view;

    }

    private void initial() {
        list.add("朋友圈");
        list.add("视频号");
        list.add("直播");
        list.add("扫一扫");
        list.add("摇一摇");
        list.add("看一看");
        list.add("搜一搜");
        list.add("附近");
        list.add("购物");
        list.add("游戏");
        list.add("小说");
        list.add("音乐");
        list.add("收藏");
        list.add("小程序");
        list.add("其他功能");
        list.add("999+");
    }

}