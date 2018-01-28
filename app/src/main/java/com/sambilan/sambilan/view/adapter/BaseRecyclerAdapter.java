package com.sambilan.sambilan.view.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sambilan.sambilan.view.adapter.listener.BaseRecyclerListener;
import com.sambilan.sambilan.view.adapter.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/27/2018.
 */

public abstract class BaseRecyclerAdapter<T, L extends BaseRecyclerListener, VH extends BaseViewHolder<T, L>>
        extends RecyclerView.Adapter<VH> {

    private List<T> data;
    private L listener;
    private LayoutInflater layoutInflater;

    public BaseRecyclerAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        data = new ArrayList<>(); // biar gak null pointer
    }

    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T item = data.get(position);
        holder.onBind(item, listener);
    }

    @Override
    public int getItemCount() {
        return null != data ? data.size() : 0;
    }

    public void setListener(L listener) {
        this.listener = listener;
    }

    @NonNull
    public View inflate(@LayoutRes int layoutId, @Nullable final ViewGroup parent) {
        return layoutInflater.inflate(layoutId, parent, false);
    }

    @NonNull
    public View inflate(@LayoutRes int layoutId, @Nullable final ViewGroup parent, boolean attachRoot) {
        return layoutInflater.inflate(layoutId, parent, attachRoot);
    }

    public void updateModel(List<T> newData) {
        if (null == newData) {
            throw new IllegalArgumentException("newModel is Null");
        }

        this.data.clear();
        this.data.addAll(newData);
        notifyDataSetChanged();
    }
}
