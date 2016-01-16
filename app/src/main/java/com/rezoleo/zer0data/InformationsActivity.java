package com.rezoleo.zer0data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class InformationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations);

    }

    protected void hideLinearLayout(RelativeLayout layoutToHide)
    {
        layoutToHide.setVisibility(View.GONE);
    }

}
