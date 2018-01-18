package com.sambilan.sambilan.item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sambilan.sambilan.R;

/**
 * Created by Afriandi Haryanto on 1/17/2018.
 */

public class JobItemAdapter extends RecyclerView.Adapter<JobItemAdapter.JobItemViewHolder> {

    private Context context;
    private JobItemListener jobItemListener;

    public JobItemAdapter(Context context, JobItemListener listener) {
        this.context = context;
        this.jobItemListener = listener;
    }

    @Override
    public JobItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        /** buat object view dulu buat nampung 'layout' itemjob*/
        View viewHolder = LayoutInflater.from(context).inflate(R.layout.item_job, parent,
                false);

        /** buat objectnya */
        return new JobItemViewHolder(viewHolder, jobItemListener);
    }

    @Override
    public void onBindViewHolder(JobItemViewHolder holder, int position) {

        /** lakukan pengisian view disini*/
        holder.tv_title.setText("Job Title");
        holder.tv_lokasi.setText("Angkringan Enaknan, Jl. Pandega Satya no. 2");
        holder.tv_lokasi.setHorizontallyScrolling(true);
        holder.tv_fee.setText("Rp 10.000.000");
    }

    @Override
    public int getItemCount() {

        /**
         * jumlah item yang mau ditampilkan
         */
        return 10;
    }

    public class JobItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tv_title;
        public TextView tv_lokasi;
        public TextView tv_fee;

        public JobItemListener itemListener;
        public JobItemViewHolder(View itemView, JobItemListener listener) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_jobTitle);
            tv_lokasi = itemView.findViewById(R.id.tv_alamat);
            tv_fee = itemView.findViewById(R.id.tv_bayaran);

            /** set listener untuk memeriksa touch user */
            this.itemListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.onClickJobItem(getAdapterPosition());
        }
    }

    public interface JobItemListener{
        public void onClickJobItem(int position);
    }
}
