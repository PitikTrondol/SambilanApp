package com.sambilan.sambilan.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.presenter.DetailJobsPresenter;

public class DetailJobActivity extends AppCompatActivity
        implements DetailJobsPresenter.DetailJobResultCallback<Job, Throwable>{

    private DetailJobsPresenter detailJobsPresenter;
    private Job detailJob;

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

        detailJobsPresenter = new DetailJobsPresenter();
        detailJobsPresenter.getDetailJob(this, 1);

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
    public void OnSuccessResult(Job first) {
        setData(first);
    }

    @Override
    public void OnFailureResult(Throwable second) {
        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
    }


    private void setData(Job detailJob) {
       tv_lowongan.setText("Lowongan Sebagai "+detailJob.getTitle());
       tv_dilihat.setText("10");
       tv_dilamar.setText(""+detailJob.getCount_apply());

        tv_gaji.setText(detailJob.getSalary());
        tv_value_tgl_posting.setText(detailJob.getStart_due());
        tv_value_tgl_tutup.setText(detailJob.getEnd_due());

        tv_deskripsi_lowongan.setText(detailJob.getDesc() + "\nKapasitas : " + detailJob.getCapacity());

       tv_detail_perusahaan.setText(detailJob.getCompany().getName()+"\nAlamat : "+detailJob.getCompany().getAddress());
       tv_value_lowongannya.setText(""+detailJob.getCount_invitation());
       tv_value_ratingnya.setText("4.9");

        if(null !=detailJob.getCompany().getLogoUrl())
            Glide.with(this).load(detailJob.getCompany().getLogoUrl().trim()).into(iv_logo);

    }

    private View.OnClickListener onLamarPekerjaan =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(DetailJobActivity.this, "Lamar Pekerjaan", Toast.LENGTH_SHORT).show();
                }
            };

}
