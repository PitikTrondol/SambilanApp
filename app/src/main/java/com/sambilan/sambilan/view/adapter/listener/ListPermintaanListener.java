package com.sambilan.sambilan.view.adapter.listener;

/**
 * Created by Afriandi Haryanto on 1/29/2018.
 */

public interface ListPermintaanListener extends BaseRecyclerListener {
    public void onClickButtonTerima(int jobID);
    public void onClickButtonTolak(int jobID);
    public void onClickListPermintaan(int jobID);
}
