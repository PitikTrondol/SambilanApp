package com.sambilan.sambilan.view.adapter.employee.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.response.AppliedJobResponse;
import com.sambilan.sambilan.view.adapter.listener.ListSelesaiListener;

/**
 * Created by Afriandi Haryanto on 1/29/2018.
 */

public class ListSelesaiHolder extends BaseViewHolder<AppliedJobResponse, ListSelesaiListener> {

    private TextView tv_title;
    private TextView tv_lokasi;
    private TextView tv_fee;
    private TextView tv_company;

    private ImageView iv_image;
    private Button btn_penilaian;
    private LinearLayout cardSelesai;

    public ListSelesaiHolder(View itemView) {
        super(itemView);

        tv_title = itemView.findViewById(R.id.tv_jobTitle);
        tv_lokasi = itemView.findViewById(R.id.tv_alamat);
        tv_fee = itemView.findViewById(R.id.tv_bayaran);
        tv_company = itemView.findViewById(R.id.tv_company);

        btn_penilaian = itemView.findViewById(R.id.btn_selesai_rating);
        iv_image = itemView.findViewById(R.id.iv_item_image);
        cardSelesai = itemView.findViewById(R.id.cv_selesai);
    }

    @Override
    public void onBind(final AppliedJobResponse data, @Nullable final ListSelesaiListener listener) {
        tv_title.setText(data.getJob().getTitle());
        tv_company.setText(data.getJob().getCompany().getName());
        tv_lokasi.setText(data.getJob().getCompany().getName());
        tv_fee.setText(data.getJob().getSalary());

        if(null != data.getJob().getCompany().getLogoUrl()) {
            Glide.with(itemView.getContext()).load(data.getJob().getCompany().getLogoUrl().trim()).into(iv_image);
        }

        btn_penilaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickBeriPenilaian(data.getJob().getId());
            }
        });

        cardSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickJob(data.getJob().getId());
            }
        });
    }
}
