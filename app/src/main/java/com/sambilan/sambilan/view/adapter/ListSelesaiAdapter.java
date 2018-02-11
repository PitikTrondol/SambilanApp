package com.sambilan.sambilan.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.response.AppliedJobResponse;
import com.sambilan.sambilan.view.adapter.listener.ListSelesaiListener;
import com.sambilan.sambilan.view.adapter.viewholder.ListSelesaiHolder;

/**
 * Created by Afriandi Haryanto on 1/29/2018.
 */

public class ListSelesaiAdapter extends BaseRecyclerAdapter<AppliedJobResponse, ListSelesaiListener, ListSelesaiHolder> {


    public ListSelesaiAdapter(Context context) {
        super(context);
    }

    @Override
    public ListSelesaiHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflate(R.layout.item_selesai, parent, false);
        CardView cv = view.findViewById(R.id.cv_selesai);
        cv.setBackgroundResource(0);

        return new ListSelesaiHolder(view);
    }
}
