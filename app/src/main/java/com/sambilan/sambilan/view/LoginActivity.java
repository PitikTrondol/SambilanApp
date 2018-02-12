package com.sambilan.sambilan.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.utils.CacheManager;
import com.sambilan.sambilan.model.DaoSession;
import com.sambilan.sambilan.model.LoginRequest;
import com.sambilan.sambilan.model.LoginResponse;
import com.sambilan.sambilan.model.User;
import com.sambilan.sambilan.presenter.LoginPagePresenter;

/**
 * Created by Andhika Putranto on 2/4/2018.
 */

public class LoginActivity extends AppCompatActivity {

    EditText et_email, et_password;
    Button btn_masuk;
    ConstraintLayout cl_login;
    LoginPagePresenter presenter;
    LoginRequest request;
    TextView tv_daftar;
    CacheManager cacheManager;
    AlertDialog alertDialog;
    CharSequence[] value = {"Pekerja", "Pekerjakan"};

    private DaoSession daoSession;
    private User userDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cacheManager = CacheManager.getInstance(LoginActivity.this);
        et_email = findViewById(R.id.et_email);
        cl_login = findViewById(R.id.cl_login);
        et_password = findViewById(R.id.et_password);
        btn_masuk = findViewById(R.id.btn_masuk);
        tv_daftar = findViewById(R.id.tv_daftar);

        tv_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiaglogAlertDaftar();
            }
        });

        presenter = new LoginPagePresenter();
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request = new LoginRequest(et_email.getText().toString().trim(),
                        et_password.getText().toString().trim());

                Log.d("LOGIN", "Before : ---------"+((SambilanApplication) getApplication()).getAppToken());
                presenter.postAll(loginPagePresenter, request);
            }
        });

        daoSession = ((SambilanApplication)getApplication()).getDaoSession();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private LoginPagePresenter.LoginResultCallback<LoginResponse, Throwable> loginPagePresenter =
            new LoginPagePresenter.LoginResultCallback<LoginResponse, Throwable>() {
                @Override
                public void OnSuccessResult(LoginResponse first) {
                    if (first.getStatus().equals("ok")) {
                        Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                        startActivity(intent);

                        cacheManager.saveString(CacheManager.TOKEN_KEY, first.getLoginObject().getToken());
                        cacheManager.saveString(CacheManager.ROLE_KEY,
                                first.getLoginObject().getUser().getRole());

                        ((SambilanApplication) getApplication()).setAppToken(first.getLoginObject().getToken());
                        ((SambilanApplication) getApplication()).setLoggedIn(true);

                        daoSession.getUserDao().delete(first.getLoginObject().getUser());
                        daoSession.getUserDao().insert(first.getLoginObject().getUser());
                        Log.d("LOGIN", "After : ---------"+((SambilanApplication) getApplication()).getAppToken());

                    } else {

                        Toast.makeText(LoginActivity.this, "Error bos", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(LoginActivity.this,
                            "TELEK " + second.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            };

    public void DiaglogAlertDaftar() {

        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Daftar Sebagai");
        builder.setSingleChoiceItems(value, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch (i) {
                    case 0:
                        GoToNextScreen(LoginActivity.this, RegisterPekerjaActivity.class);
                        break;
                    case 1:
                        GoToNextScreen(LoginActivity.this, RegisterPekerjakanActivity.class);
                        break;

                }
                alertDialog.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    private void GoToNextScreen(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
    }
}
