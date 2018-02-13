package com.sambilan.sambilan.view.fragment;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.model.DaoSession;
import com.sambilan.sambilan.model.User;
import com.sambilan.sambilan.utils.CacheManager;
import com.sambilan.sambilan.view.HalamanDiterimaActivity;
import com.sambilan.sambilan.view.HalamanMenungguActivity;
import com.sambilan.sambilan.view.HalamanSelesaiActivity;
import com.sambilan.sambilan.view.MainMenuActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ProfilePageFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_profileFungsi;
    private LinearLayout buttonLogout;
    private AlertDialog.Builder dialogBuilder;
    private User user;
    private DaoSession daoSession;

    private TextView namaHeader;
    private TextView posisi;

    private TextView nama;
    private TextView alamat;
    private TextView telepon;
    private TextView email;
    private TextView skill;

    public ProfilePageFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ll_profileFungsi = view.findViewById(R.id.ll_profile_fungsi);
        buttonLogout = view.findViewById(R.id.logout);

        namaHeader = view.findViewById(R.id.profile_name);
        posisi = view.findViewById(R.id.posisi);

        nama = view.findViewById(R.id.val_name);
        alamat = view.findViewById(R.id.val_alamat);
        telepon = view.findViewById(R.id.val_telepon);
        email = view.findViewById(R.id.val_email);
        skill = view.findViewById(R.id.val_skill);

        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialogBuilder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            dialogBuilder = new AlertDialog.Builder(getContext());
        }

        dialogBuilder.setTitle("Logout")
                .setMessage("Apakah anda yakin..?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainMenuActivity) getActivity()).setLogout(getActivity());
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert);

        for (int i = 0; i < ll_profileFungsi.getChildCount(); i++) {
            ll_profileFungsi.getChildAt(i).setOnClickListener((this));
        }

        daoSession = ((SambilanApplication) getActivity().getApplication()).getDaoSession();

        int id = CacheManager.getInstance(getContext()).getInt(CacheManager.USER_ID_KEY);
        List<User> userList = new ArrayList<>();
        userList.addAll(daoSession.getUserDao().loadAll());

        for(User test : userList) {
            if(null != test) {
                this.user = test;
                break;
            }
        }
        setData();

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.show();
            }
        });
    }

    private void setData() {

        namaHeader.setText(user.getFullname());
        posisi.setText(user.getRole().equals("employee") ? "Pekerja" : "Pemberi Kerja");

        Resources res = getResources();
        String text = String.format(res.getString(R.string.valueIdentitas), user.getFullname());
        nama.setText(text);

        text = String.format(res.getString(R.string.valueIdentitas), user.getAddress());
        alamat.setText(text);

        text = String.format(res.getString(R.string.valueIdentitas), user.getPhone());
        telepon.setText(text);

        text = String.format(res.getString(R.string.valueIdentitas), "tetep.sihomo@gmail.com");
        email.setText(text);

        text = String.format(res.getString(R.string.valueSkill), "Kaya Raya", "Profesional Stalker");
        skill.setText(text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_permintaan: {
                Toast.makeText(getContext(), "Not Ready Yet", Toast.LENGTH_SHORT).show();
//                ((MainMenuActivity) getActivity()).goToNextScreen(view.getContext(), HalamanPermintaanActivity.class);
            }
            break;

            case R.id.ll_menunggu: {
                if (((SambilanApplication) getActivity().getApplication()).getAppRole().equals("employer"))
                    Toast.makeText(getContext(), "Not Ready Yet", Toast.LENGTH_SHORT).show();
                else
                    ((MainMenuActivity) getActivity()).goToNextScreen(view.getContext(), HalamanMenungguActivity.class);
            }
            break;

            case R.id.ll_diterima: {
                if (((SambilanApplication) getActivity().getApplication()).getAppRole().equals("employer"))
                    Toast.makeText(getContext(), "Not Ready Yet", Toast.LENGTH_SHORT).show();
                else
                    ((MainMenuActivity) getActivity()).goToNextScreen(view.getContext(), HalamanDiterimaActivity.class);
            }
            break;

            case R.id.ll_selesai: {
                if (((SambilanApplication) getActivity().getApplication()).getAppRole().equals("employer"))
                    Toast.makeText(getContext(), "Not Ready Yet", Toast.LENGTH_SHORT).show();
                else
                    ((MainMenuActivity) getActivity()).goToNextScreen(view.getContext(), HalamanSelesaiActivity.class);
            }
            break;
        }
    }

}
