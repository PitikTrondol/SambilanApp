package com.sambilan.sambilan.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.Login;
import com.sambilan.sambilan.model.LoginRequest;
import com.sambilan.sambilan.model.LoginResponse;
import com.sambilan.sambilan.presenter.LoginPagePresenter;

import retrofit2.HttpException;

/**
 * Created by Andhika Putranto on 2/4/2018.
 */

public class LoginActivity extends AppCompatActivity {

    EditText et_email,et_password;
    Button btn_masuk;
    ConstraintLayout cl_login;
    LoginPagePresenter presenter;
    LoginRequest request;
    TextView tv_daftar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email=findViewById(R.id.et_email);
        cl_login = findViewById(R.id.cl_login);
        et_password=findViewById(R.id.et_password);
        btn_masuk=findViewById(R.id.btn_masuk);
        tv_daftar = findViewById(R.id.tv_daftar);
        presenter=new LoginPagePresenter();
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request = new LoginRequest(et_email.getText().toString(),et_password.getText().toString());
                presenter.postAll(loginPagePresenter,request);
            }
        });
    }
    private LoginPagePresenter.LoginResultCallback<LoginResponse,Throwable> loginPagePresenter = new LoginPagePresenter.LoginResultCallback<LoginResponse,Throwable>(){

        @Override
        public void OnSuccessResult(LoginResponse first) {
            if(first.getStatus().equals("Ok"))
            {
                Intent intent = new Intent(LoginActivity.this,SambilanActivity.class);
                startActivity(intent);
            }else
            {
                Toast.makeText(LoginActivity.this,"Error bos",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void OnFailureResult(Throwable second) {
            if (second instanceof HttpException) {
                Toast.makeText(LoginActivity.this,
                        "JEMBUT " + ((HttpException) second).code(),
                        Toast.LENGTH_SHORT).show();
            } else if (second instanceof NullPointerException) {
                Toast.makeText(LoginActivity.this,
                        "TELEK " + ((NullPointerException) second).getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this,
                        "TELEK " + second.getMessage(),
                        Toast.LENGTH_SHORT).show();

                System.out.println("TELEK "+second.getMessage());
            }
        }
    };
    public void DaftarSekarang(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView =inflater.inflate(R.layout.popup_register,null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView,width,height,focusable);
        popupWindow.showAtLocation(cl_login, Gravity.CENTER,300,300);
    }
}
