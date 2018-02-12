package com.sambilan.sambilan.view.adapter.employee.viewholder;

import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.view.adapter.listener.ListPermintaanListener;
import com.sambilan.sambilan.view.helper.ImgurHelper;

/**
 * Created by Afriandi Haryanto on 1/29/2018.
 */

public class ListPermintaanHolder extends BaseViewHolder<Job, ListPermintaanListener> {

    private TextView tv_title;
    private TextView tv_company;
    private TextView tv_lokasi;
    private TextView tv_fee;

    private Button btn_diterima;
    private Button btn_ditolak;

    private RelativeLayout cv_job;
    private ImageView iv_image;
    private ImgurHelper helper;

    public ListPermintaanHolder(View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_jobTitle);
        tv_lokasi = itemView.findViewById(R.id.tv_alamat);
        tv_fee = itemView.findViewById(R.id.tv_bayaran);
        tv_company = itemView.findViewById(R.id.tv_company);

        iv_image = itemView.findViewById(R.id.iv_item_image);
        btn_diterima = itemView.findViewById(R.id.btn_permintaan_diterima);
        btn_ditolak = itemView.findViewById(R.id.btn_permintaan_ditolak);
        cv_job = itemView.findViewById(R.id.cv_permintaan);
    }

    @Override
    public void onBind(final Job data, @Nullable final ListPermintaanListener listener) {
        tv_title.setText(data.getTitle());
        tv_company.setText(data.getCompany().getName());
        tv_lokasi.setText(data.getCompany().getAddress());
        tv_fee.setText(data.getSalary());
        helper = new ImgurHelper(data.getCompany().getLogoUrl().trim());
        Glide.with(itemView.getContext()).load(helper.getDirectLink()).into(iv_image);

        btn_diterima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickButtonTerima(data.getId());
            }
        });

        btn_ditolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickButtonTolak(data.getId());
            }
        });

        cv_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickListPermintaan(data.getId());
            }
        });
    }
}
