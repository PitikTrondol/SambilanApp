package com.sambilan.sambilan.view.adapter.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.view.adapter.listener.ListSelesaiListener;

/**
 * Created by Afriandi Haryanto on 1/29/2018.
 */

public class ListSelesaiHolder extends BaseViewHolder<Job, ListSelesaiListener> {

    public TextView tv_title;
    public TextView tv_lokasi;
    public TextView tv_fee;
    private ImageView iv_image;
    private Button btn_penilaian;

    public ListSelesaiHolder(View itemView) {
        super(itemView);

        tv_title = itemView.findViewById(R.id.tv_jobTitle);
        tv_lokasi = itemView.findViewById(R.id.tv_alamat);
        tv_fee = itemView.findViewById(R.id.tv_bayaran);
        btn_penilaian = itemView.findViewById(R.id.btn_selesai_rating);
    }

    @Override
    public void onBind(Job data, @Nullable final ListSelesaiListener listener) {
        tv_title.setText(data.getTitle());
        tv_lokasi.setText(data.getCompany_address());
        tv_fee.setText(data.getSalary());

        btn_penilaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickBeriPenilaian();
            }
        });
    }
}
