package com.rezoleo.zer0data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        hideView(findViewById(R.id.card_recognized));
    }

    protected void hideView(View viewToHide)
    {
        viewToHide.setVisibility(View.GONE);
    }

}
