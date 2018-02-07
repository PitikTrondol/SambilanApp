package com.sambilan.sambilan.presenter;

/**
 * Created by Afriandi Haryanto on 2/7/2018.
 */

public interface ResponseResultCallback<A, B> {
    void OnSuccessResult(A first);
    void OnFailureResult(B second);
}
