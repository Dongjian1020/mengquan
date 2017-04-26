package com.jiangdongjian.mengquan.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fangxu.library.DragContainer;
import com.fangxu.library.DragListener;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiangdongjian.mengquan.R;
import com.jiangdongjian.mengquan.adapter.HomeRecyclerAdapter;
import com.jiangdongjian.mengquan.adapter.MyAdapter;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Yellow5A5 on 16/10/21.
 */

public class GroupFragment extends Fragment {

    private XRecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private ArrayList<String> listData;
    private int refreshTime = 0;
    private int times = 0;
    private LayoutInflater mInflater;
    private FlyBanner mBannerNet;
    public static final String[] mImagesUrl = {
            "http://sjbz.fd.zol-img.com.cn/t_s208x312c/g5/M00/00/01/ChMkJ1fJUYiIEtDDAAGcif4js8oAAU9egJmm74AAZyh409.jpg",
            "http://sjbz.fd.zol-img.com.cn/t_s208x312c/g5/M00/00/01/ChMkJlfJUVqIG9E4AAXem303o8UAAU9dgMjCU4ABd6z036.jpg",
            "http://sjbz.fd.zol-img.com.cn/t_s208x312c/g5/M00/00/01/ChMkJlfJUjqIDN3JAB7-6F8yxe0AAU9iwKdl68AHv8A91.jpeg",
            "http://sjbz.fd.zol-img.com.cn/t_s208x312c/g5/M00/00/01/ChMkJ1fJUgCIbbFZAAeQkZsNOrIAAU9hQK2pFEAB5Cp127.jpg",
            "http://sjbz.fd.zol-img.com.cn/t_s208x312c/g5/M00/00/01/ChMkJlfJUdiILuIRABPBbXo-N1MAAU9gQHLTqEAE8GF358.jpg"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group, container, false);
//        View header1 = inflater.inflate(R.layout.item_follow,container,false);
        View header2 = inflater.inflate(R.layout.iterm_group_head2,container,false);

        initRecycleView(header2);
        mInflater = LayoutInflater.from(getActivity());
        mBannerNet = (FlyBanner) inflater.inflate(R.layout.iterm_group_head1,container,false);
        initNetBanner();
        initView(view,mBannerNet,header2);
        return view;
    }

    private void initRecycleView(View header2) {
        RecyclerView recyclerView = (RecyclerView) header2.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        HomeRecyclerAdapter adapter = new HomeRecyclerAdapter(getContext());
        recyclerView.setAdapter(adapter);

        DragContainer dragContainer = (DragContainer) header2.findViewById(R.id.drag_recycler_view);
//        dragContainer.setFooterDrawer(new NormalFooterDrawer.Builder(this, 0xffffc000).setIconDrawable(getResources().getDrawable(R.drawable.left_2)).build());
        dragContainer.setDragListener(new DragListener() {
            @Override
            public void onDragEvent() {
                Log.e("onDragEvent","=======>");
            }
        });
    }

    private void initView(View view,View header1,View header2) {
        mRecyclerView = (XRecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.divider);

        mRecyclerView.addItemDecoration(mRecyclerView.new DividerItemDecoration(dividerDrawable));

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);

//        View header = LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_header, view,false);
//        View header = mInflater.inflate(R.layout.item_follow,null);
        mRecyclerView.addHeaderView(header1);
        mRecyclerView.addHeaderView(header2);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime ++;
                times = 0;
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        listData.clear();
                        for(int i = 0; i < 15 ;i++){
                            listData.add("item" + i + "after " + refreshTime + " times of refresh");
                        }
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                if(times < 2){
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            for(int i = 0; i < 15 ;i++){
                                listData.add("item" + (1 + listData.size() ) );
                            }
                            mRecyclerView.loadMoreComplete();
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for(int i = 0; i < 9 ;i++){
                                listData.add("item" + (1 + listData.size() ) );
                            }
                            mRecyclerView.setNoMore(true);
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
                times ++;
            }
        });

        listData = new  ArrayList<String>();
        mAdapter = new MyAdapter(listData);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.refresh();
    }

    private void initNetBanner() {

        List<String> imgesUrl = new ArrayList<>();
        for (int i = 0; i < mImagesUrl.length; i++) {
            imgesUrl.add(mImagesUrl[i]);
        }
        mBannerNet.setImagesUrl(imgesUrl);

        mBannerNet.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                toast("点击了第" + position + "张图片");
            }
        });
    }
}
