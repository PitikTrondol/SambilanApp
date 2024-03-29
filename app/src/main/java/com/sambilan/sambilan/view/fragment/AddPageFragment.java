package com.sambilan.sambilan.view.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.AddJobResponse;
import com.sambilan.sambilan.presenter.AddJobPresenter;
import com.sambilan.sambilan.presenter.ResponseResultCallback;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

/**
 * Created by Andhika Putranto on 2/3/2018.
 */

public class AddPageFragment extends Fragment {

    private String appToken = "8e0bb59034fb13f8b640f5ba857930a1bd7ba487dabfaee7a8d685034d166194";
    private String tglMulai,tglTutup,tglSelesai;

    private EditText etJudul;
    private EditText etKategori;
    private EditText etPabrik;
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

    DatePickerDialog datePickerDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tambah, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appToken = ((SambilanApplication)getActivity().getApplication()).getAppToken();
        etJudul = view.findViewById(R.id.et_judul);
        etKategori = view.findViewById(R.id.et_kategori);
        etPabrik = view.findViewById(R.id.et_pabrik);
        etDeskripsi = view.findViewById(R.id.et_deskripsi);
        etKapasitas = view.findViewById(R.id.et_kapasistas);
        etGaji = view.findViewById(R.id.et_gaji);
        etTglMulai = view.findViewById(R.id.et_tgl_mulai);
        etTglSelesai = view.findViewById(R.id.et_tgl_selesai);
        etTglTutup = view.findViewById(R.id.et_tgl_tutup);
        etLokasi = view.findViewById(R.id.et_lokasi);

        btnTambah = view.findViewById(R.id.btn_tambah);
        btnTambah.setOnClickListener(onTambahPekerjaan);

        tglMulai = "";
        tglSelesai = "";
        tglTutup = "";

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        etTglMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayOfMonth, int month, int year) {
                        NumberFormat numberFormat = new DecimalFormat("00");

                        tglMulai = numberFormat.format(dayOfMonth) + "/" + numberFormat.format(month + 1) + "/" +
                                numberFormat.format(year);

                        etTglMulai.setText(numberFormat.format(dayOfMonth) + "/" + numberFormat.format(month + 1) + "/" +
                                numberFormat.format(year));
                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });

        etTglSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayOfMonth, int month, int year) {
                        NumberFormat numberFormat = new DecimalFormat("00");

                        tglSelesai = numberFormat.format(dayOfMonth) + "/" + numberFormat.format(month + 1) + "/" +
                                numberFormat.format(year);

                        etTglSelesai.setText(numberFormat.format(dayOfMonth) + "/" + numberFormat.format(month + 1) + "/" +
                                numberFormat.format(year));
                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });

        etTglTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayOfMonth, int month, int year) {
                        NumberFormat numberFormat = new DecimalFormat("00");

                        tglTutup = numberFormat.format(dayOfMonth) + "/" + numberFormat.format(month + 1) + "/" +
                                numberFormat.format(year);

                        etTglTutup.setText(numberFormat.format(dayOfMonth) + "/" + numberFormat.format(month + 1) + "/" +
                                numberFormat.format(year));
                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });

    }

    private ResponseResultCallback<AddJobResponse, Throwable> postJobCallback =
            new ResponseResultCallback<AddJobResponse, Throwable>() {
                @Override
                public void OnSuccessResult(AddJobResponse first) {
                    addJobPresenter.postingJob(postJobCallback, appToken, postingJob);
                    Toast.makeText(getActivity(), "Berhasil ditambahkan", Toast.LENGTH_SHORT).show();
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
                    postingJob.setCategory_id(Integer.parseInt(etKategori.getText().toString().trim()));
                    postingJob.setCompany_id(Integer.parseInt(etPabrik.getText().toString().trim()));
                    postingJob.setDesc(etDeskripsi.getText().toString().trim());
                    postingJob.setCapacity(Integer.parseInt(etKapasitas.getText().toString().trim()));
                    postingJob.setSalary(etGaji.getText().toString().trim());
                    postingJob.setStart_due(etTglMulai.getText().toString().trim());
                    postingJob.setEnd_due(etTglSelesai.getText().toString().trim());
                    postingJob.setExpire_due(etTglTutup.getText().toString().trim());
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
