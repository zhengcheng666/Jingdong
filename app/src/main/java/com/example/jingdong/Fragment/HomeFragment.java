package com.example.jingdong.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.jingdong.Adapter.BannerAdapter;
import com.example.jingdong.Adapter.ButtonAdapter;
import com.example.jingdong.Adapter.SingAdapter;
import com.example.jingdong.Adapter.TitleAdapter;
import com.example.jingdong.R;


public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView re = view.findViewById(R.id.re);
        //创建VirtualLayoutManager对象，与RecycleView绑定
        VirtualLayoutManager Manager = new VirtualLayoutManager(getContext());
        //设置回收复用池大小
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        re.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);




        //第一行搜索框,通栏布局
        SingleLayoutHelper singleLayout= new SingleLayoutHelper();
        //公共属性
        singleLayout.setItemCount(1);// 设置布局里Item个数
        singleLayout.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayout.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayout.setBgColor(Color.LTGRAY);// 设置背景颜色
        singleLayout.setAspectRatio(12);// 设置设置布局内每行布局的宽与高的比
        //创建适配器
        SingAdapter singAdapter = new SingAdapter(singleLayout, getContext());


        //第二行,通栏布局
        SingleLayoutHelper bannerHelper = new SingleLayoutHelper();
        //公共属性
        bannerHelper.setItemCount(1);// 设置布局里Item个数
        //创建适配器
        BannerAdapter bannerAdapter = new BannerAdapter(bannerHelper, getContext());


        //第三行搜索框,通栏布局
        SingleLayoutHelper buttonhelper = new SingleLayoutHelper();
        //公共属性
        buttonhelper.setItemCount(5);// 设置布局里Item个数
        singleLayout.setPadding(0, 0, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayout.setMargin(0, 0, 0, 0);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //创建适配器
        ButtonAdapter buttonAdapter = new ButtonAdapter(buttonhelper, getContext());

        //第四行标题，线性布局
        SingleLayoutHelper titlehelper = new SingleLayoutHelper();
        //公共属性
        titlehelper.setItemCount(1);// 设置布局里Item个数
//        titlehelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        titlehelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        titlehelper.setBgColor(Color.LTGRAY);// 设置背景颜色
        //创建适配器
        TitleAdapter titleAdapter = new TitleAdapter(titlehelper, getContext());


        //创建适配器的包
        DelegateAdapter adapter = new DelegateAdapter(Manager,true);
        //添加第一个布局  搜索框
        adapter.addAdapter(singAdapter);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(titleAdapter);
        adapter.addAdapter(buttonAdapter);






        re.setLayoutManager(Manager);
        re.setAdapter(adapter);



    }
}