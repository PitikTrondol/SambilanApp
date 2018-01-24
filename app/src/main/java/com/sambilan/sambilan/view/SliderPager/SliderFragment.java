package com.sambilan.sambilan.view.SliderPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sambilan.sambilan.R;

/**
 * Created by Andhika Putranto on 1/18/2018.
 */

public class SliderFragment extends Fragment {

    public String imageURL;
    public View rootView;
    public static final String LABEL_KEY = "SliderFragment.image";

    public static SliderFragment newInstance(String image) {

        Bundle args = new Bundle();
        args.putString(LABEL_KEY, image);
        SliderFragment fragment = new SliderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        imageURL = getArguments().getString(LABEL_KEY);
        rootView = inflater.inflate(R.layout.fragment_image, container, false);
        ImageView img = (ImageView) rootView.findViewById(R.id.iv_carousel);
        Glide.with(getActivity()).load(imageURL).into(img);
        return rootView;
    }
}

