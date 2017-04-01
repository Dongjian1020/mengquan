package com.jiangdongjian.mengquan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jiangdongjian.mengquan.activity.LoginActivity;
import com.jiangdongjian.mengquan.R;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Yellow5A5 on 16/10/21.
 */

public class ThirdFragment extends Fragment {

    private CircleImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_center, container, false);
        imageView = (CircleImageView) view.findViewById(R.id.profile_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"lalal",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
