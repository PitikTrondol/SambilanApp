package com.sambilan.sambilan.view.fragment;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.response.JobResponse;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.presenter.ResponseResultCallback;
import com.sambilan.sambilan.view.MainMenuActivity;

/**
 * Created by Afriandi Haryanto on 2/4/2018.
 */

public class MiscelaneousFragment extends Fragment {

    public static final int OFFLINE_MODE = 0;
    public static final int EMPTY_LIST_MODE = 1;
    private static int fragmenMode;

    private TextView tvKeterangan;
    private Button btnAction;

    private ProgressBar progressBar;
    private LandingPagePresenter dummyPresenter;

    public MiscelaneousFragment() {

    }

    public static MiscelaneousFragment newInstance(final int mode) {

        fragmenMode = mode;
        return new MiscelaneousFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_misc, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dummyPresenter = new LandingPagePresenter();
        progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        Resources res = getResources();
        String[] text = res.getStringArray(R.array.misc_fragment);

        tvKeterangan = view.findViewById(R.id.tv_miscellaneous);
        tvKeterangan.setText(text[fragmenMode]);

        btnAction = view.findViewById(R.id.btnReload);
        btnAction.setText(text[fragmenMode + 1]);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmenMode == OFFLINE_MODE)
                    dummyLoading();
            }
        });
    }

    public void dummyLoading() {
        progressBar.setVisibility(View.VISIBLE);
        tvKeterangan.setVisibility(View.GONE);
        btnAction.setVisibility(View.GONE);
        dummyPresenter.getGuestJoblist(homeJobCallback, 1, 1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private ResponseResultCallback<JobResponse, Throwable> homeJobCallback =
            new ResponseResultCallback<JobResponse, Throwable>() {
                @Override
                public void OnSuccessResult(JobResponse first) {
                    ((MainMenuActivity)getActivity()).loadFragment(new LandingPageFragment());
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    progressBar.setVisibility(View.GONE);
                    tvKeterangan.setVisibility(View.VISIBLE);
                    btnAction.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(),
                            "TIDAK ADA JARINGAN ",
                            Toast.LENGTH_SHORT).show();
                }
            };
}
