package com.sambilan.sambilan.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sambilan.sambilan.R;

/**
 * Created by Afriandi Haryanto on 2/4/2018.
 */

public class MiscelaneousFragment extends Fragment {

    private static String text2Show;
    private TextView textView;
    public MiscelaneousFragment() {
    }

    public static MiscelaneousFragment newInstance(String newText) {

        text2Show = newText;
        return new MiscelaneousFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_misc, container, false);
        textView = rootView.findViewById(R.id.tv_miscellaneous);
        textView.setText(text2Show);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
