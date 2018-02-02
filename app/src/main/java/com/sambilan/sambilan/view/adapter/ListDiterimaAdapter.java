package com.sambilan.sambilan.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.request.RequestOptions;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.JobList;
import com.sambilan.sambilan.view.adapter.listener.ListDiterimaListener;
import com.sambilan.sambilan.view.adapter.viewholder.ListDiterimaHolder;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ListDiterimaAdapter extends BaseRecyclerAdapter<JobList, ListDiterimaListener , ListDiterimaHolder> {

    public ListDiterimaAdapter(Context context) {
        super(context);
    }

    @Override
    public ListDiterimaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =inflate(R.layout.item_diterima,parent,false);
//        RelativeLayout rl = view.findViewById(R.id.rl_diterima);
//        rl.setBackgroundResource(0);


        return new ListDiterimaHolder(view);
    }
}
