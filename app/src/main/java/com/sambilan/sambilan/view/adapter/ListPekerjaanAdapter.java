package com.sambilan.sambilan.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.JobList;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;
import com.sambilan.sambilan.view.adapter.viewholder.ListJobHolder;

/**
 * Created by Afriandi Haryanto on 1/28/2018.
 */

public class ListPekerjaanAdapter extends BaseRecyclerAdapter<JobList, ListJobListener, ListJobHolder> {

    public ListPekerjaanAdapter(Context context) {
        super(context);
    }

    @Override
    public ListJobHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListJobHolder(inflate(R.layout.item_job, parent));
    }
}
