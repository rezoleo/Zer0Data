package com.rezoleo.zer0data;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rezoleo.zer0data.common.Common;
import com.rezoleo.zer0data.network.AsyncInfoClient;
import com.rezoleo.zer0data.object.AllInformation;
import com.rezoleo.zer0data.object.LoginInformation;
import com.rezoleo.zer0data.object.Person;
import com.rezoleo.zer0data.toolbox.Utils;
import com.squareup.picasso.Picasso;

public class InformationActivity extends AppCompatActivity {

    private NfcAdapter mAdapter;
    private PendingIntent mPendingIntent;
    private IntentFilter[] mFilters;
    private String[][] mTechLists;

    private AllInformation allInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        prepareNfc();

        Intent intent = getIntent();
        resolveIntent(intent);
    }


    private void resolveIntent(Intent intent) {
        // 1) Parse the intent and get the action that triggered this intent
        String action = intent.getAction();

        // 2) Check if it was triggered by a tag discovered interruption.
        if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)) {
            //  3) Get an instance of the TAG from the NfcAdapter
            Tag tagFromIntent = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

            String tagUid = Utils.ByteArrayToHexString(tagFromIntent.getId());
            Log.i("NFC", tagUid);
        } else {
            Bundle b = intent.getExtras();
            LoginInformation loginInformation = b.getParcelable("loginInformation");
            new AsyncInfoClient(this).execute("login", loginInformation.getLogin());
        }
    }


    public void updateAllInformation(AllInformation allInformation) {
        this.allInformation = allInformation;
        Person person = allInformation.getPerson();
        setText(R.id.owner, person.getLogin());
        setText(R.id.first_name, person.getFirstname());
        setText(R.id.last_name, person.getLastname());
        setText(R.id.gender, "M".equals(person.getSex()) ? getString(R.string.man) : getString(R.string.woman));
        setText(R.id.age, person.getMajor() ? getString(R.string.full_age) : getString(R.string.under_age));
        setPhoto(Common.URL + "/api/picture/" + person.getLogin());
    }

    private void setText(int id, String string) {
        TextView tv = (TextView) findViewById(id);
        tv.setText(string);
    }

    private void setPhoto(String url) {
        ImageView iv = (ImageView) findViewById(R.id.photo);
        Picasso.with(this)
                .load(url)
                .fit()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(iv);
    }
    private void prepareNfc() {
        mAdapter = NfcAdapter.getDefaultAdapter(this);

        mPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED);

        try {
            ndef.addDataType("*/*");
        } catch (IntentFilter.MalformedMimeTypeException e) {
            throw new RuntimeException("fail", e);
        }
        mFilters = new IntentFilter[] {
                ndef,
        };

        // Setup a tech list for all NfcF tags
        mTechLists = new String[][] { new String[] { MifareClassic.class.getName() } };
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("Foreground dispatch", "Discovered tag with intent: " + intent);
        resolveIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.enableForegroundDispatch(this, mPendingIntent, mFilters, mTechLists);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAdapter.disableForegroundDispatch(this);
    }

    protected void hideView(View viewToHide)
    {
        viewToHide.setVisibility(View.GONE);
    }

}
