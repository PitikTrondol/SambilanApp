package com.sambilan.sambilan.view.adapter.employee.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;
import com.sambilan.sambilan.view.helper.ImgurHelper;

/**
 * Created by Afriandi Haryanto on 1/28/2018.
 */

public class ListJobHolder extends BaseViewHolder<Job, ListJobListener> {

    private TextView tv_title;
    private TextView tv_company;
    private TextView tv_lokasi;
    private TextView tv_fee;
    private ImageView iv_image;

    private ImgurHelper helper;

    public ListJobHolder(View itemView) {
        super(itemView);

        tv_title = itemView.findViewById(R.id.tv_jobTitle);
        tv_company = itemView.findViewById(R.id.tv_company);
        tv_lokasi = itemView.findViewById(R.id.tv_alamat);
        tv_fee = itemView.findViewById(R.id.tv_bayaran);
        iv_image = itemView.findViewById(R.id.iv_item_image);
    }

    @Override
    public void onBind(final Job data, @Nullable final ListJobListener listener) {
        tv_title.setText(data.getTitle());
        tv_company.setText(data.getCompany().getName());
        tv_lokasi.setText(data.getCompany().getAddress());
        tv_fee.setText(data.getSalary());

        if(null != data.getCompany().getLogoUrl()) {
            helper = new ImgurHelper(data.getCompany().getLogoUrl().trim());
            Glide.with(itemView.getContext()).load(helper.getDirectLink()).into(iv_image);
        }

        if (null != listener)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickJob(data.getId());
                }
            });
    }
}
