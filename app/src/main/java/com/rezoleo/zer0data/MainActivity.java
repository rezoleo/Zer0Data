package com.rezoleo.zer0data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rezoleo.zer0data.network.AsyncLoginClient;
import com.rezoleo.zer0data.object.LoginInformation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void connect(View v) {
        TextView tvLogin = (TextView) findViewById(R.id.login);
        TextView tvPassword = (TextView) findViewById(R.id.password);
        String login = null;
        try {
            login = tvLogin.getText().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String password = null;
        try {
            password = tvPassword.getText().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new AsyncLoginClient(this).execute(login, password);
    }

    public void goToInformationActivity(LoginInformation loginInformation) {
        Intent intent = new Intent(this, InformationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("loginInformation", loginInformation);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
