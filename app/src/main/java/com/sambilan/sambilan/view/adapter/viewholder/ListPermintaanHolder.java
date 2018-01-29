package com.sambilan.sambilan.view.adapter.viewholder;

import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.view.adapter.listener.ListPermintaanListener;

/**
 * Created by Afriandi Haryanto on 1/29/2018.
 */

public class ListPermintaanHolder extends BaseViewHolder<Job, ListPermintaanListener> {

    public TextView tv_title;
    public TextView tv_lokasi;
    public TextView tv_fee;

    private Button btn_diterima;
    private Button btn_ditolak;

    private CardView cv_job;
    public ImageView iv_image;
    public ListPermintaanHolder(View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_jobTitle);
        tv_lokasi = itemView.findViewById(R.id.tv_alamat);
        tv_fee = itemView.findViewById(R.id.tv_bayaran);

        btn_diterima = itemView.findViewById(R.id.btn_permintaan_diterima);
        btn_ditolak = itemView.findViewById(R.id.btn_permintaan_ditolak);
        cv_job = itemView.findViewById(R.id.cv_permintaan);
    }

    @Override
    public void onBind(Job data, @Nullable final ListPermintaanListener listener) {
        tv_title.setText(data.getTitle());
        tv_lokasi.setText(data.getCompany_address());
        tv_fee.setText(data.getSalary());

        btn_diterima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickButtonTerima();
            }
        });

        btn_ditolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickButtonTolak();
            }
        });

        cv_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickListPermintaan();
            }
        });
    }
}
