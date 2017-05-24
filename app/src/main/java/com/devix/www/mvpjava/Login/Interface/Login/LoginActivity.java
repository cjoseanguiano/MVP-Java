package com.devix.www.mvpjava.Login.Interface.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.devix.www.mvpjava.Login.Interface.Login.Interface.LoginPresenter;
import com.devix.www.mvpjava.Login.Interface.Login.Interface.LoginView;
import com.devix.www.mvpjava.Login.Interface.Main.Interface.FindItemsInteractor;
import com.devix.www.mvpjava.Login.Interface.Main.MainActivity;
import com.devix.www.mvpjava.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private ProgressBar mProgressBar;
    private EditText mUserName;
    private EditText mPassword;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mProgressBar = (ProgressBar) findViewById(R.id.mprogress);
        mUserName = (EditText) findViewById(R.id.musername);
        mPassword = (EditText) findViewById(R.id.mpassword);
        findViewById(R.id.mbutton).setOnClickListener(this);
        mPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        mUserName.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        mPassword.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        mPresenter.validateCredentials(mUserName.getText().toString(), mPassword.getText().toString());
    }
}
