package com.sambilan.sambilan.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.view.adapter.listener.ListMenungguListener;
import com.sambilan.sambilan.view.adapter.viewholder.ListMenungguHolder;

/**
 * Created by febrian on 31/01/18.
 */

public class ListMenungguAdapter extends BaseRecyclerAdapter<Job, ListMenungguListener, ListMenungguHolder> {

    public ListMenungguAdapter(Context context) {
        super(context);
    }

    @Override
    public ListMenungguHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflate(R.layout.item_menunggu, parent, false);
        CardView cv = view.findViewById(R.id.cv_menunggu);
        cv.setBackgroundResource(0);

        return new ListMenungguHolder(view);
    }
}
