package com.sambilan.sambilan.view.adapter.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.JobList;
import com.sambilan.sambilan.view.adapter.listener.ListDiterimaListener;
import com.sambilan.sambilan.view.helper.ImgurHelper;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ListDiterimaHolder extends BaseViewHolder<JobList, ListDiterimaListener> {

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
    }

    @Override
    public void onBind(JobList data, @Nullable ListDiterimaListener listener) {
        tv_title.setText(data.getTitle());
        tv_company.setText(data.getCompany_name());
        tv_salary.setText(data.getSalary());
        tv_date_sebelum.setText(data.getAccept_date());
        tv_date_sesudah.setText(data.getDate_done());

        helper= new ImgurHelper(data.getLogo_url().trim());
        Glide.with(itemView.getContext()).load(helper.getDirectLink()).apply(new RequestOptions().fitCenter()).into(iv_company);
////
//        rl_diterima.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onClickDiterima();
//            }
//        });
    }
}


