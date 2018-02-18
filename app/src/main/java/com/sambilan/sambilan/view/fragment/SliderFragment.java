package com.sambilan.sambilan.view.fragment;

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
    private static final String ARG_PARAM1 = "param1";

    private String param1;
    private String imageURL;

    public SliderFragment() {
    }

    public static SliderFragment newInstance(String param1) {
        SliderFragment fragment = new SliderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        imageURL = getArguments().getString(ARG_PARAM1);
        ImageView img = view.findViewById(R.id.image);
        Glide.with(getActivity()).load(imageURL).into(img);
        return view;
    }


}


