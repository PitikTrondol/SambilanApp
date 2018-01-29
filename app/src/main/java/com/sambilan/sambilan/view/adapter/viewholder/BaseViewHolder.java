package com.sambilan.sambilan.view.adapter.viewholder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sambilan.sambilan.view.adapter.listener.BaseRecyclerListener;

/**
 * Created by Afriandi Haryanto on 1/28/2018.
 */

public abstract class BaseViewHolder <T, L extends BaseRecyclerListener> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(T data, @Nullable L listener);
}
