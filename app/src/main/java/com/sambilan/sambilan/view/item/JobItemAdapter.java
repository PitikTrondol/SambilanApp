package com.sambilan.sambilan.view.item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;

import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/17/2018.
 */

public class JobItemAdapter extends RecyclerView.Adapter<JobItemAdapter.JobItemViewHolder> {

    private Context context;
    private JobItemListener jobItemListener;
    private List<Job> jobs;

    public JobItemAdapter(Context context,List<Job> jobs, JobItemListener listener) {
        this.context = context;
        this.jobItemListener = listener;
        this.jobs = jobs;
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
        holder.tv_title.setText(jobs.get(position).getJob_desc());
        holder.tv_lokasi.setText(jobs.get(position).getCompany_address());
        holder.tv_fee.setText(jobs.get(position).getJob_salary());
//        Glide.with(context).load(jobs.get(position).)
    }

    @Override
    public int getItemCount() {

        /**
         * jumlah item yang mau ditampilkan
         */
        return jobs.size();
    }

    public class JobItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tv_title;
        public TextView tv_lokasi;
        public TextView tv_fee;
        public ImageView iv_image;

        public JobItemListener itemListener;
        public JobItemViewHolder(View itemView, JobItemListener listener) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_jobTitle);
            tv_lokasi = itemView.findViewById(R.id.tv_alamat);
            tv_fee = itemView.findViewById(R.id.tv_bayaran);
            iv_image = itemView.findViewById(R.id.iv_jobImage);

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
