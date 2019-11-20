package com.example.mvpandroid;

public interface LoginView {
    void loginFail();
    void loginSuccessful();
    void navigateHome();
    void setErrorUserName();
    void setErrorPassword();
}
