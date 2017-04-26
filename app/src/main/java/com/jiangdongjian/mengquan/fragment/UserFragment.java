package com.jiangdongjian.mengquan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.droi.sdk.feedback.DroiFeedback;
import com.droi.sdk.selfupdate.DroiUpdate;
import com.jiangdongjian.mengquan.activity.FollowActivity;
import com.jiangdongjian.mengquan.activity.LoginActivity;
import com.jiangdongjian.mengquan.R;
import com.jiangdongjian.mengquan.activity.UserDetailActivity;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Yellow5A5 on 16/10/21.
 */

public class UserFragment extends Fragment {

    private CircleImageView mImageView;
    private RippleView mBt_Follow;
    private RippleView mBt_Collection;
    private RippleView mBt_Publish;
    private RippleView mBt_FeedBack;
    private RippleView mBt_Settings;
    private RippleView mBt_Update;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_center, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mImageView = (CircleImageView) view.findViewById(R.id.profile_image);
        mBt_Follow = (RippleView) view.findViewById(R.id.rect_follow);
        mBt_Collection = (RippleView) view.findViewById(R.id.rect_collection);
        mBt_Publish = (RippleView) view.findViewById(R.id.rect_publish);
        mBt_FeedBack = (RippleView) view.findViewById(R.id.rect_feedback);
        mBt_Settings = (RippleView) view.findViewById(R.id.rect_settings);
        mBt_Update = (RippleView) view.findViewById(R.id.rect_update);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        mBt_Follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FollowActivity.class);
                startActivity(intent);
            }
        });
        mBt_Collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mBt_Publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mBt_FeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DroiFeedback.callFeedback(getContext());
            }
        });
        mBt_Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), UserDetailActivity.class);
                startActivity(intent);
            }
        });
        mBt_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DroiUpdate.manualUpdate(getContext());
            }
        });
    }
}
