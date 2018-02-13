package com.sambilan.sambilan.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.RegisterRequest;
import com.sambilan.sambilan.model.RegisterResponse;
import com.sambilan.sambilan.presenter.RegisterPresenter;

import java.util.ArrayList;

import retrofit2.HttpException;

/**
 * Created by Andhika Putranto on 2/7/2018.
 */

public class RegisterPekerjakanActivity extends AppCompatActivity{
    private EditText et_nama_pekerjakan;
    private EditText et_nama_perusahaan;
    private EditText et_email_pekerjakan;
    private EditText et_kata_sandi_pekerjakan;
    private EditText et_ulang_kata_pekerjakan;
    private EditText et_no_telp_pekerjakan;
    private EditText et_alamat_pekerjakan;
    private TextView role_pekerjakan;

    private RegisterRequest registerRequest;
    private RegisterPresenter register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_company);
        et_nama_pekerjakan = findViewById(R.id.et_nama_pekerjakan);
        et_nama_perusahaan = findViewById(R.id.et_company_pekerjakan);
        et_email_pekerjakan= findViewById(R.id.et_email_pekerjakan);
        et_kata_sandi_pekerjakan = findViewById(R.id.et_kata_sandi_pekerjakan);
        et_ulang_kata_pekerjakan = findViewById(R.id.et_ulang_sandi_pekerjakan);
        et_no_telp_pekerjakan = findViewById(R.id.et_no_telp_pekerjakan);
        et_alamat_pekerjakan = findViewById(R.id.et_alamat_pekerjakan);
        role_pekerjakan = findViewById(R.id.tv_role_pekerjakan);
        role_pekerjakan.setText("employer");
        ArrayList<String> list = new ArrayList<>();

        Toolbar toolbar = findViewById(R.id.tb_pekerjakan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Daftar Pekerjakan");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        register = new RegisterPresenter();

        findViewById(R.id.btn_masuk_pekerjakan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_kata_sandi_pekerjakan.getText().toString().equals(et_ulang_kata_pekerjakan.getText().toString()))
                {
                    Toast.makeText(RegisterPekerjakanActivity.this,"Kata sandi harus sama",Toast.LENGTH_SHORT).show();
                }else if(et_kata_sandi_pekerjakan.getText().toString().length()<8){
                    Toast.makeText(RegisterPekerjakanActivity.this,"Kata Sandi harus terdiri minimal 8 karakter", Toast.LENGTH_SHORT).show();
                }else {
                    registerRequest = new RegisterRequest(et_email_pekerjakan.getText().toString(), et_kata_sandi_pekerjakan.getText().toString(),
                            role_pekerjakan.getText().toString(), null, et_nama_pekerjakan.getText().toString(), null, et_no_telp_pekerjakan.getText().toString()
                            , et_nama_perusahaan.getText().toString(), et_alamat_pekerjakan.getText().toString());
                    register.postRegister(registerPresenter, registerRequest);
                }
            }
        });
    }

    private RegisterPresenter.RegisterResultCallback<RegisterResponse,Throwable> registerPresenter =
            new RegisterPresenter.RegisterResultCallback<RegisterResponse, Throwable>() {
                @Override
                public void OnSuccessResult(RegisterResponse first) {
                    if(first.getStatus().equalsIgnoreCase("ok")){
                        Intent intent = new Intent(RegisterPekerjakanActivity.this,MainMenuActivity.class);
                        startActivity(intent);
                        Toast.makeText(RegisterPekerjakanActivity.this,"Sukses Registrasi",Toast.LENGTH_SHORT).show();

                        finish();
                    }else {
                        Toast.makeText(RegisterPekerjakanActivity.this,"eror",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    if (second instanceof HttpException) {
                        Toast.makeText(RegisterPekerjakanActivity.this,
                                "JEMBUT " + ((HttpException) second).code(),
                                Toast.LENGTH_SHORT).show();
                    } else if (second instanceof NullPointerException) {
                        Toast.makeText(RegisterPekerjakanActivity.this,
                                "TELEK " + ((NullPointerException) second).getMessage(),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterPekerjakanActivity.this,
                                "TELEK " + second.getMessage(),
                                Toast.LENGTH_SHORT).show();

                        System.out.println("TELEK " + second.getMessage());
                    }
                }
            };
}
