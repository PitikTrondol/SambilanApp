package com.sambilan.sambilan.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.response.AppliedJobResponse;
import com.sambilan.sambilan.view.adapter.listener.ListDiterimaListener;
import com.sambilan.sambilan.view.adapter.viewholder.ListDiterimaHolder;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ListDiterimaAdapter extends BaseRecyclerAdapter<AppliedJobResponse, ListDiterimaListener , ListDiterimaHolder> {

    public ListDiterimaAdapter(Context context) {
        super(context);
    }

    @Override
    public ListDiterimaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListDiterimaHolder(inflate(R.layout.item_diterima,parent,false));
    }
}
