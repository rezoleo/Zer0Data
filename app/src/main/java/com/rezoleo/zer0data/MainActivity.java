package com.rezoleo.zer0data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.rezoleo.zer0data.network.AsyncLoginClient;
import com.rezoleo.zer0data.object.LoginInformation;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private TextView tvLogin;
    private TextView tvPassword;
    private CheckBox cbShouldRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbShouldRemember = (CheckBox) findViewById(R.id.logs_remember);
        tvLogin = (TextView) findViewById(R.id.login);
        tvPassword = (TextView) findViewById(R.id.password);

        sharedPref = getPreferences(Context.MODE_PRIVATE);
        prepareCredentials();
    }

    private void prepareCredentials() {
        boolean should_remember = sharedPref.getBoolean(getString(R.string.pref_remember), false);

        cbShouldRemember.setChecked(should_remember);

        if (should_remember) {
            String pref_login = sharedPref.getString(getString(R.string.pref_user), "");
            String pref_password = sharedPref.getString(getString(R.string.pref_password), "");

            tvLogin.setText(pref_login);
            tvPassword.setText(pref_password);
        }
    }

    public void connect(View v) {
        String login = getTvLogin();
        String password = getTvPassword();

        new AsyncLoginClient(this).execute(login, password);
    }

    public void goToInformationActivity(LoginInformation loginInformation) {
        Intent intent = new Intent(this, InformationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("loginInformation", loginInformation);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPref.edit();

        if (cbShouldRemember.isChecked()) {
            editor.putString(getString(R.string.pref_user), getTvLogin());
            editor.putString(getString(R.string.pref_password), getTvPassword());
        }
        editor.putBoolean(getString(R.string.pref_remember), cbShouldRemember.isChecked());

        editor.apply();
    }

    public String getTvLogin() {
        String login = null;
        try {
            login = tvLogin.getText().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }

    public String getTvPassword() {
        String password = null;
        try {
            password = tvPassword.getText().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
}
