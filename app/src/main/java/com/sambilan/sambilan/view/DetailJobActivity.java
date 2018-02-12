package com.sambilan.sambilan.view;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.model.ApplyJobBody;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.AppliedJobResponse;
import com.sambilan.sambilan.model.response.PostResponse;
import com.sambilan.sambilan.presenter.DetailJobsPresenter;
import com.sambilan.sambilan.presenter.ResponseResultCallback;

import java.util.ArrayList;
import java.util.List;

public class DetailJobActivity extends AppCompatActivity
        implements DetailJobsPresenter.DetailJobResultCallback<Job, Throwable> {

    public static final String JOB_ID = "JOB_ID";
    private DetailJobsPresenter detailJobsPresenter;
    private String appToken;
    private Job job;
    private List<Integer> waitingList;

    private ImageView iv_logo;
    private TextView tv_lowongan;
    private TextView tv_dilihat;
    private TextView tv_dilamar;

    private TextView tv_gaji;
    private TextView tv_value_tgl_posting;
    private TextView tv_value_tgl_tutup;

    private TextView tv_deskripsi_lowongan;

    private TextView tv_detail_perusahaan;
    private TextView tv_value_lowongannya;
    private TextView tv_value_ratingnya;

    private Button btn_lamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job);

        Intent detail = getIntent();
        int id = detail.getIntExtra(JOB_ID, 1);
        waitingList = new ArrayList<>();
        appToken = ((SambilanApplication) getApplication()).getAppToken();
        detailJobsPresenter = new DetailJobsPresenter();
        detailJobsPresenter.getDetailJob(this, id);
        detailJobsPresenter.getJobOnWait(getListWaiting, appToken, "waiting");

        iv_logo = findViewById(R.id.iv_logo);
        tv_lowongan = findViewById(R.id.tv_lowongan);
        tv_dilihat = findViewById(R.id.tv_value_dilihat);
        tv_dilamar = findViewById(R.id.tv_value_dilamar);

        tv_gaji = findViewById(R.id.tv_gaji);
        tv_value_tgl_posting = findViewById(R.id.tv_value_tgl_posting);
        tv_value_tgl_tutup = findViewById(R.id.tv_value_tgl_tutup);

        tv_deskripsi_lowongan = findViewById(R.id.tv_deskripsi_lowongannya);

        tv_detail_perusahaan = findViewById(R.id.tv_detail_perusahaannya);
        tv_value_lowongannya = findViewById(R.id.tv_value_lowongannya);
        tv_value_ratingnya = findViewById(R.id.tv_value_rating);

        btn_lamar = findViewById(R.id.btn_lamar);
        btn_lamar.setOnClickListener(onLamarPekerjaan);


    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public void OnSuccessResult(Job first) {
        this.job = first;
        setData(first);
    }

    @Override
    public void OnFailureResult(Throwable second) {
        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
    }


    private void setData(Job detailJob) {
        tv_lowongan.setText("Lowongan Sebagai " + detailJob.getTitle());
        tv_dilihat.setText("10");
        tv_dilamar.setText("" + detailJob.getCount_apply());
        tv_gaji.setText(detailJob.getSalary());
        tv_value_tgl_posting.setText(detailJob.getStart_due());
        tv_value_tgl_tutup.setText(detailJob.getEnd_due());
        tv_deskripsi_lowongan.setText(detailJob.getDesc() + "\nKapasitas : " + detailJob.getCapacity());
        tv_detail_perusahaan.setText(detailJob.getCompany().getName() + "\nAlamat : " + detailJob.getCompany().getAddress());
        tv_value_lowongannya.setText("" + detailJob.getCount_invitation());
        tv_value_ratingnya.setText("4.9");

        if (null != detailJob.getCompany().getLogoUrl())
            Glide.with(this).load(detailJob.getCompany().getLogoUrl().trim()).into(iv_logo);

        if(!((SambilanApplication)getApplication()).isLoggedIn()) {
            btn_lamar.setText("Login");
        } else if(isInWaitingList(detailJob.getId())) {
            setDisableButton();
        } else {
            btn_lamar.setText("Apply Pekerjaan Ini");
        }
    }

    private View.OnClickListener onLamarPekerjaan =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(!((SambilanApplication)getApplication()).isLoggedIn()) {
                        startActivity(new Intent(DetailJobActivity.this, LoginActivity.class));
                    }
                    ApplyJobBody body = new ApplyJobBody(job.getId());
                    detailJobsPresenter.applyJob(applyCallback, appToken, body);
                }
            };


    private ResponseResultCallback<PostResponse<String, Job>, Throwable> applyCallback =
            new ResponseResultCallback<PostResponse<String, Job>, Throwable>() {
                @Override
                public void OnSuccessResult(PostResponse<String, Job> first) {
                    postAndUpdate(first);
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(DetailJobActivity.this, ""+second.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };

    private ResponseResultCallback<List<AppliedJobResponse>, Throwable> getListWaiting =
            new ResponseResultCallback<List<AppliedJobResponse>, Throwable>() {
                @Override
                public void OnSuccessResult(List<AppliedJobResponse> first) {
                    waitingList.addAll(getWaitingList(first));
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(DetailJobActivity.this, ""+second.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            };

    private void postAndUpdate(PostResponse<String, Job> first) {
        if (first.getStatus().equals("ok")) {
            setDisableButton();
            detailJobsPresenter.getJobOnWait(getListWaiting, appToken, "waiting");
        }
        else
            Toast.makeText(DetailJobActivity.this, "" + first.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private List<Integer> getWaitingList (List<AppliedJobResponse> responses) {
        List<Integer> listID = new ArrayList<>();

        for(AppliedJobResponse a : responses) {
            listID.add(a.getJob().getId());
        }

        return  listID;
    }

    private boolean isInWaitingList(int jobID) {
        for(Integer a : waitingList) {
            if(a ==jobID) return true;
        }
        return false;
    }

    private void setDisableButton() {
        btn_lamar.setEnabled(false);
        int color = ResourcesCompat.getColor(getResources(), R.color.colorCommonGrey, null);
        btn_lamar.setBackgroundColor(color);
        color = ResourcesCompat.getColor(getResources(), R.color.colorCommonOrange, null);
        btn_lamar.setTextColor(color);
        btn_lamar.setText("Menunggu Diterima");
    }
}
