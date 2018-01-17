package com.sambilan.sambilan.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sambilan.sambilan.R;

import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/17/2018.
 */

public class JobItemAdapter extends RecyclerView.Adapter<JobItemAdapter.JobItemViewHolder> {

    @Override
    public JobItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(JobItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class JobItemViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_title;
        public TextView tv_lokasi;
        public TextView tv_fee;

        public JobItemViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_jobTitle);
            tv_lokasi = itemView.findViewById(R.id.tv_jobTitle);
            tv_fee = itemView.findViewById(R.id.tv_jobTitle);
        }
    }
}
