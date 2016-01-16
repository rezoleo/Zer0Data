package com.rezoleo.zer0data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InformationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations);

        hideView(findViewById(R.id.card_recognized));
    }

    protected void hideView(View viewToHide)
    {
        viewToHide.setVisibility(View.GONE);
    }

}
