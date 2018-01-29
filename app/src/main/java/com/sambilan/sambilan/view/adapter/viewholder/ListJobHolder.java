package com.sambilan.sambilan.view.adapter.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;

/**
 * Created by Afriandi Haryanto on 1/28/2018.
 */

public class ListJobHolder extends BaseViewHolder<Job, ListJobListener> {

    public TextView tv_title;
    public TextView tv_lokasi;
    public TextView tv_fee;
    public ImageView iv_image;

    public ListJobHolder(View itemView) {
        super(itemView);

        tv_title = itemView.findViewById(R.id.tv_jobTitle);
        tv_lokasi = itemView.findViewById(R.id.tv_alamat);
        tv_fee = itemView.findViewById(R.id.tv_bayaran);
    }

    @Override
    public void onBind(Job data, @Nullable final ListJobListener listener) {
        tv_title.setText(data.getTitle());
        tv_lokasi.setText(data.getCompany_address());
        tv_fee.setText(data.getSalary());

        if (null != listener)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickJob();
                }
            });
    }
}
