package com.sambilan.sambilan.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.cache.CacheManager;
import com.sambilan.sambilan.view.HalamanDiterimaActivity;
import com.sambilan.sambilan.view.HalamanMenungguActivity;
import com.sambilan.sambilan.view.HalamanPermintaanActivity;
import com.sambilan.sambilan.view.HalamanSelesaiActivity;
import com.sambilan.sambilan.view.MainMenuActivity;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ProfilePageFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_profileFungsi;
    private LinearLayout buttonLogout;

    public ProfilePageFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ll_profileFungsi = view.findViewById(R.id.ll_profile_fungsi);
        buttonLogout = view.findViewById(R.id.logout);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < ll_profileFungsi.getChildCount(); i++) {
            ll_profileFungsi.getChildAt(i).setOnClickListener((this));
        }

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainMenuActivity) getActivity()).setLogout(getActivity());
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_permintaan: {
                ((MainMenuActivity) getActivity()).goToNextScreen(view.getContext(), HalamanPermintaanActivity.class);
            }
            break;

            case R.id.ll_menunggu: {
                ((MainMenuActivity) getActivity()).goToNextScreen(view.getContext(), HalamanMenungguActivity.class);
            }
            break;

            case R.id.ll_diterima: {
                ((MainMenuActivity) getActivity()).goToNextScreen(view.getContext(), HalamanDiterimaActivity.class);
            }
            break;

            case R.id.ll_selesai: {
                ((MainMenuActivity) getActivity()).goToNextScreen(view.getContext(), HalamanSelesaiActivity.class);
            }
            break;
        }
    }

}
