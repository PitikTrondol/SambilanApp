package com.sambilan.sambilan.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.view.HalamanDiterimaActivity;
import com.sambilan.sambilan.view.HalamanPermintaanActivity;
import com.sambilan.sambilan.view.HalamanSelesaiActivity;
import com.sambilan.sambilan.view.ProfilePageActivity;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ProfilePageFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_profileFungsi;
    ImageView iv_permintaan;

    public ProfilePageFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ll_profileFungsi = view.findViewById(R.id.ll_profile_fungsi);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < ll_profileFungsi.getChildCount(); i++) {
            ll_profileFungsi.getChildAt(i).setOnClickListener((this));
        }
    }


    private void GoToNextScreen(FragmentActivity fragmentContext, Class<?> cls) {
        Intent intent = new Intent(fragmentContext, cls);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_permintaan: {
                GoToNextScreen(getActivity(), HalamanPermintaanActivity.class);
            }
            break;

            case R.id.ll_menunggu: {
                Toast.makeText(getActivity(), "Menunggu", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.ll_diterima: {
                GoToNextScreen(getActivity(), HalamanDiterimaActivity.class);
            }
            break;

            case R.id.ll_selesai: {
                GoToNextScreen(getActivity(), HalamanSelesaiActivity.class);
            }
            break;
        }
    }

}
