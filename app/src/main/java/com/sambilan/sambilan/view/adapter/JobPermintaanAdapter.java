package com.sambilan.sambilan.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;

import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/25/2018.
 */

public class JobPermintaanAdapter extends RecyclerView.Adapter<JobPermintaanAdapter.PermintaanViewHolder> {

    /**
     *  Maap gaaaan, janji dah besok dibuatin yang generic kalo sempet
     */

    private Context context;
    private PermintaanListener permintaanListener;
    private List<Job> jobs;

    public JobPermintaanAdapter(Context context, List<Job> jobs, PermintaanListener permintaanListener) {
        this.context = context;
        this.permintaanListener = permintaanListener;
        this.jobs = jobs;
    }

    @Override
    public PermintaanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewHolder = LayoutInflater.from(context).inflate(R.layout.item_permintaan, parent,
                false);

        return new PermintaanViewHolder(viewHolder, permintaanListener);
    }

    @Override
    public void onBindViewHolder(PermintaanViewHolder holder, int position) {
        holder.tv_title.setText("Title "+position);
        holder.tv_lokasi.setText("Alamat "+position);
        holder.tv_fee.setText("Gaji "+position);
    }

    @Override
    public int getItemCount() {
//        return jobs.size();
        return 10;
    }

    public class PermintaanViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_title;
        public TextView tv_lokasi;
        public TextView tv_fee;
        public ImageView iv_image;
        public Button btn_terima;
        public Button btn_tolak;
        private CardView cv_jobCard;

        public PermintaanViewHolder(View itemView, final PermintaanListener listener) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_jobTitle);
            tv_lokasi = itemView.findViewById(R.id.tv_alamat);
            tv_fee = itemView.findViewById(R.id.tv_bayaran);
            iv_image = itemView.findViewById(R.id.iv_jobImage);

            cv_jobCard = itemView.findViewById(R.id.cv_job_list);
            cv_jobCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickPermintaanItem();
                }
            });

            btn_terima = itemView.findViewById(R.id.btn_permintaan_diterima);
            btn_terima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickTerima();
                }
            });

            btn_tolak = itemView.findViewById(R.id.btn_permintaan_ditolak);
            btn_tolak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickTolak();
                }
            });
        }
    }

    public interface PermintaanListener {
        public void onClickPermintaanItem();
        public void onClickTerima();
        public void onClickTolak();
    }
}
