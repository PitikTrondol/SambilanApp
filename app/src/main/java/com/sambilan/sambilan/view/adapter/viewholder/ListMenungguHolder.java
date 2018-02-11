package com.sambilan.sambilan.view.adapter.viewholder;

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
import com.sambilan.sambilan.model.response.AppliedJobResponse;
import com.sambilan.sambilan.view.adapter.listener.BaseRecyclerListener;
import com.sambilan.sambilan.view.adapter.listener.ListMenungguListener;
import com.sambilan.sambilan.view.adapter.listener.ListPermintaanListener;
import com.sambilan.sambilan.view.helper.ImgurHelper;

/**
 * Created by febrian on 31/01/18.
 */

public class ListMenungguHolder extends BaseViewHolder<AppliedJobResponse, ListMenungguListener> {

    private TextView tv_title;
    private TextView tv_company;
    private TextView tv_lokasi;
    private TextView tv_fee;

    private Button btn_batalkan;

    private RelativeLayout cv_job;
    private ImageView iv_image;
    private ImgurHelper helper;

    public ListMenungguHolder(View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_jobTitle);
        tv_lokasi = itemView.findViewById(R.id.tv_alamat);
        tv_fee = itemView.findViewById(R.id.tv_bayaran);
        tv_company = itemView.findViewById(R.id.tv_company);

        iv_image = itemView.findViewById(R.id.iv_item_image);
        btn_batalkan = itemView.findViewById(R.id.btn_batalkan);
        cv_job = itemView.findViewById(R.id.cv_menunggu);
    }

    @Override
    public void onBind(final AppliedJobResponse data, @Nullable final ListMenungguListener listener) {
        tv_title.setText(data.getJob().getTitle());
        tv_company.setText(data.getJob().getCompany().getName());
        tv_lokasi.setText(data.getJob().getCompany().getAddress());
        tv_fee.setText(data.getJob().getSalary());

        if(null != data.getJob().getCompany().getLogoUrl())
            Glide.with(itemView.getContext()).load(data.getJob().getCompany().getLogoUrl().trim()).into(iv_image);

        btn_batalkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickBatalkan(data.getId());
            }
        });

        cv_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickJob(data.getJob().getId());
            }
        });
    }
}
