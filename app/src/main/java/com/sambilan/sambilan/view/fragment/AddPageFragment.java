package com.sambilan.sambilan.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.AddJobResponse;
import com.sambilan.sambilan.presenter.AddJobPresenter;
import com.sambilan.sambilan.presenter.ResponseResultCallback;

/**
 * Created by Andhika Putranto on 2/3/2018.
 */

public class AddPageFragment extends Fragment {

    private String appToken = "6472ebdeefc99d1b5ebc6c95da56ef82f144b19c4db3c2ea4da17a6bb103372a";

    private EditText etJudul;
    private EditText etDeskripsi;
    private EditText etKapasitas;
    private EditText etGaji;
    private EditText etTglMulai;
    private EditText etTglSelesai;
    private EditText etTglTutup;
    private EditText etLokasi;
    private Button btnTambah;

    private Job postingJob;
    private AddJobPresenter addJobPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tambah, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etJudul = view.findViewById(R.id.et_judul);
        etDeskripsi = view.findViewById(R.id.et_deskripsi);
        etKapasitas = view.findViewById(R.id.et_kapasistas);
        etGaji = view.findViewById(R.id.et_gaji);
        etTglMulai = view.findViewById(R.id.et_tgl_mulai);
        etTglSelesai = view.findViewById(R.id.et_tgl_selesai);
        etTglTutup = view.findViewById(R.id.et_tgl_tutup);
        etLokasi = view.findViewById(R.id.et_lokasi);

        btnTambah = view.findViewById(R.id.btn_tambah);
        btnTambah.setOnClickListener(onTambahPekerjaan);

    }

    private ResponseResultCallback<AddJobResponse, Throwable> postJobCallback =
            new ResponseResultCallback<AddJobResponse, Throwable>() {
                @Override
                public void OnSuccessResult(AddJobResponse first) {
                    addJobPresenter.postingJob(postJobCallback, appToken, postingJob);
                }

                @Override
                public void OnFailureResult(Throwable second) {

                }
            };

    private View.OnClickListener onTambahPekerjaan =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    postingJob = new Job();
                    postingJob.setTitle(etJudul.getText().toString().trim());
                    postingJob.setDesc(etDeskripsi.getText().toString().trim());
                    postingJob.setCapacity(Integer.parseInt(etKapasitas.getText().toString().trim()));
                    postingJob.setSalary(etGaji.getText().toString().trim());
                    postingJob.setStart_due(etTglMulai.getText().toString().trim());
                    postingJob.setEnd_due(etTglSelesai.getText().toString().trim());
                    postingJob.setLocation(etLokasi.getText().toString().trim());

                    addJobPresenter = new AddJobPresenter();
                    addJobPresenter.postingJob(postJobCallback, appToken, postingJob);
                }
            };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
