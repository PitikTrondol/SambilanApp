package com.sambilan.sambilan.view.adapter.viewholder;

import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.view.adapter.listener.ListDiterimaListener;
import com.sambilan.sambilan.view.helper.ImgurHelper;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ListDiterimaHolder extends BaseViewHolder<Job, ListDiterimaListener> {

    private TextView tv_title;
    private TextView tv_company;
    private TextView tv_salary;
    private TextView tv_date_sebelum;
    private TextView tv_date_sesudah;

    private ImageView iv_company;
    private ImgurHelper helper;
    private RelativeLayout rl_diterima;

    public ListDiterimaHolder(View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_jobTitle_test);
        tv_company = itemView.findViewById(R.id.tv_company_test);
        tv_salary = itemView.findViewById(R.id.tv_bayaran_test);
        tv_date_sebelum = itemView.findViewById(R.id.tv_sebelum);
        tv_date_sesudah = itemView.findViewById(R.id.tv_sesudah);
        iv_company = itemView.findViewById(R.id.iv_jobImage);
        rl_diterima = itemView.findViewById(R.id.rl_diterima);
    }

    @Override
    public void onBind(final Job data, @Nullable final ListDiterimaListener listener) {
        tv_title.setText(data.getTitle());
        tv_company.setText(data.getCompany().getName());
        tv_salary.setText(data.getSalary());
        tv_date_sebelum.setText("Mulai : "+data.getStart_due());
        tv_date_sesudah.setText("Selesai : "+data.getEnd_due());

        helper= new ImgurHelper(data.getCompany().getLogo_url().trim());
        Glide.with(itemView.getContext()).load(helper.getDirectLink()).apply(new RequestOptions().fitCenter()).into(iv_company);

        rl_diterima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickDiterima(data.getId());
            }
        });
    }
}


