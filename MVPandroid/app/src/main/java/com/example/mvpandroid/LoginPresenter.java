package com.example.mvpandroid;

public class LoginPresenter {
    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username,String password){
        if (username.isEmpty()){
            loginView.setErrorUserName();
        }else if(password.isEmpty()){
            loginView.setErrorPassword();
            return;
        }else {
            if (username.equalsIgnoreCase("admin")) {
                loginView.loginSuccessful();
                loginView.navigateHome();
            } else {
                loginView.loginFail();
            }
        }

    }
}
