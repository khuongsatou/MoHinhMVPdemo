package com.example.mvpandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements  LoginView, View.OnClickListener{
    private LoginPresenter loginPresenter;
    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       loginPresenter = new LoginPresenter(this);
       initView();
       initAction();

    }

    private void initAction() {
       btnLogin.setOnClickListener(this);
    }

    private void initView() {
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin){
            String username = edtUser.getText().toString();
            String password = edtPass.getText().toString();
            loginPresenter.login(username,password);
        }
    }

    @Override
    public void loginFail() {
        Toast.makeText(this,"Login Fail",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessful() {
        Toast.makeText(this,"Login Thành Công",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateHome() {
        startActivity(new Intent(this,MangHinhChinhActivity.class));
    }

    @Override
    public void setErrorUserName() {
        edtUser.setError("Vui lòng nhập Username");
    }

    @Override
    public void setErrorPassword() {
        edtPass.setError("Vui lòng nhập Password");
    }
}
