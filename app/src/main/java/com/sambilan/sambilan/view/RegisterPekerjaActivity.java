package com.sambilan.sambilan.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.RegisterRequest;
import com.sambilan.sambilan.model.RegisterResponse;
import com.sambilan.sambilan.presenter.RegisterPresenter;

import retrofit2.HttpException;

/**
 * Created by Andhika Putranto on 2/4/2018.
 */

public class RegisterPekerjaActivity extends AppCompatActivity {

    public Spinner sp_gender;
    public EditText et_nama;
    public EditText et_email;
    public EditText et_katasandi;
    public EditText et_ulang_sandi;
    public EditText et_noTelp;
    public EditText et_alamat;
    public TextView role;

    public RegisterPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employee);
        sp_gender = findViewById(R.id.sp_gender_pekerja);
        et_nama = findViewById(R.id.et_nama_pekerja);
        et_email = findViewById(R.id.et_email_pekerja);
        et_katasandi = findViewById(R.id.et_password_pekerja);
        et_ulang_sandi = findViewById(R.id.et_ulang_sandi_pekerja);
        et_noTelp = findViewById(R.id.et_no_telp_pekerja);
        et_alamat = findViewById(R.id.et_alamat_pekerja);
        role = findViewById(R.id.tv_role_pekerja);
        role.setText("employee");

        Toolbar toolbar = findViewById(R.id.tb_pekerja);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Daftar Pekerja");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        String[] item = new String[]{"pria", "wanita"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(RegisterPekerjaActivity.this, R.layout.support_simple_spinner_dropdown_item, item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_gender.setAdapter(adapter);
        final String string = sp_gender.getSelectedItem().toString();

        presenter = new RegisterPresenter();

        findViewById(R.id.btn_masuk_pekerja).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_katasandi.getText().toString().equals(et_ulang_sandi.getText().toString()))
                {
                    Toast.makeText(RegisterPekerjaActivity.this,"Kata sandi harus sama",Toast.LENGTH_SHORT).show();
                }else if(et_katasandi.getText().toString().length()<8){
                    Toast.makeText(RegisterPekerjaActivity.this,"Kata Sandi harus terdiri minimal 8 karakter", Toast.LENGTH_SHORT).show();
                }else{
                    RegisterRequest registerPekerja = new RegisterRequest(et_email.getText().toString(),et_katasandi.getText().toString(),
                            role.getText().toString(),string,et_nama.getText().toString(),et_alamat.getText().toString(),et_noTelp.getText().toString()
                            ,null,null);
                    presenter.postRegister(registerPresenter, registerPekerja);
                }

            }
        });

    }

    private RegisterPresenter.RegisterResultCallback<RegisterResponse, Throwable> registerPresenter =
            new RegisterPresenter.RegisterResultCallback<RegisterResponse, Throwable>() {
                @Override
                public void OnSuccessResult(RegisterResponse first) {
                    if (first.getStatus().equalsIgnoreCase("ok")) {
                        Intent intent = new Intent(RegisterPekerjaActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(RegisterPekerjaActivity.this,"Sukses Registrasi",Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegisterPekerjaActivity.this, "error bos", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void OnFailureResult(Throwable second) {

                    if (second instanceof HttpException) {
                        Toast.makeText(RegisterPekerjaActivity.this,
                                "JEMBUT " + ((HttpException) second).code(),
                                Toast.LENGTH_SHORT).show();
                    } else if (second instanceof NullPointerException) {
                        Toast.makeText(RegisterPekerjaActivity.this,
                                "TELEK " + ((NullPointerException) second).getMessage(),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterPekerjaActivity.this,
                                "TELEK " + second.getMessage(),
                                Toast.LENGTH_SHORT).show();

                        System.out.println("TELEK " + second.getMessage());
                    }

                }
            };
}
