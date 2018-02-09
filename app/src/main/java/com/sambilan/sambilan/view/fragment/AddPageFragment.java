package com.sambilan.sambilan.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sambilan.sambilan.R;

/**
 * Created by Andhika Putranto on 2/3/2018.
 */

public class AddPageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tambah, container, false);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
