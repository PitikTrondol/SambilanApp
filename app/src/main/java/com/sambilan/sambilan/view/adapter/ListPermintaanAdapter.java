package com.sambilan.sambilan.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.view.adapter.listener.ListPermintaanListener;
import com.sambilan.sambilan.view.adapter.viewholder.ListPermintaanHolder;

/**
 * Created by Afriandi Haryanto on 1/29/2018.
 */

public class ListPermintaanAdapter extends BaseRecyclerAdapter<Job, ListPermintaanListener, ListPermintaanHolder> {
    public ListPermintaanAdapter(Context context) {
        super(context);
    }

    @Override
    public ListPermintaanHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflate(R.layout.item_permintaan, parent, false);
        CardView cv = view.findViewById(R.id.cv_permintaan_list);
        cv.setBackgroundResource(0);

        return new ListPermintaanHolder(view);
    }
}
