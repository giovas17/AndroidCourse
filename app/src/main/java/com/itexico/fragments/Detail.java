package com.itexico.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itexico.androidcourse.R;

/**
 * Created by darkgeat on 01/04/2017.
 */

public class Detail extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewDetail = inflater.inflate(R.layout.fragment_detail,container,false);

        return  viewDetail;
    }
}
