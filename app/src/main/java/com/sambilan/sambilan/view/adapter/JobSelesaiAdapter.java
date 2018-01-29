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
 * Created by Afriandi Haryanto on 1/26/2018.
 */

public class JobSelesaiAdapter extends RecyclerView.Adapter<JobSelesaiAdapter.SelesaiViewHolder>{

    /**
     *  Maap gaaaan, janji dah besok dibuatin yang generic kalo sempet
     */

    private Context context;
    private SelesaiListener selesaiListener;
    private List<Job> jobs;

    public JobSelesaiAdapter(Context context, List<Job> jobs, SelesaiListener permintaanListener) {
        this.context = context;
        this.selesaiListener = permintaanListener;
        this.jobs = jobs;
    }

    @Override
    public SelesaiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewHolder = LayoutInflater.from(context).inflate(R.layout.item_selesai, parent,
                false);
        CardView cv = viewHolder.findViewById(R.id.cv_permintaan);
        cv.setBackgroundResource(0);

        return new SelesaiViewHolder(viewHolder, selesaiListener);
    }

    @Override
    public void onBindViewHolder(SelesaiViewHolder holder, int position) {
        holder.tv_title.setText("Title "+position);
        holder.tv_lokasi.setText("Alamat "+position);
        holder.tv_fee.setText("Gaji "+position);
    }

    @Override
    public int getItemCount() {
//        return jobs.size();
        return 10;
    }

    public class SelesaiViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_title;
        public TextView tv_lokasi;
        public TextView tv_fee;
        public TextView tv_tanggalMulai;
        public TextView tv_tanggalSelesai;
        public ImageView iv_image;
        public Button btn_penilaian;

        public SelesaiViewHolder(View itemView, final SelesaiListener listener) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_jobTitle);
            tv_lokasi = itemView.findViewById(R.id.tv_alamat);
            tv_fee = itemView.findViewById(R.id.tv_bayaran);
            tv_tanggalMulai = itemView.findViewById(R.id.tv_tl_mulai);
            tv_tanggalSelesai = itemView.findViewById(R.id.tv_tl_selesai);

            iv_image = itemView.findViewById(R.id.iv_jobImage);
            btn_penilaian = itemView.findViewById(R.id.btn_selesai_rating);
            btn_penilaian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickBeriPenilaian();
                }
            });
        }
    }

    public interface SelesaiListener {
        public void onClickBeriPenilaian();
    }
}
