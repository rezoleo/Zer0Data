package com.rezoleo.zer0data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rezoleo.zer0data.network.AsyncLoginClient;

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
}
