package com.rezoleo.zer0data.network;

import android.os.AsyncTask;

import com.rezoleo.zer0data.common.Common;
import com.rezoleo.zer0data.object.LoginInformation;

import fr.applicationcore.object.APIException;

/**
 * Created by Thomas on 8/01/16.
 */
public class AsyncHttpClient extends AsyncTask<String, Void, Object> {
    private HttpClient httpClient = new HttpClient();

    @Override
    protected Object doInBackground(String... params) {
        String call = params[0];

        switch (call) {
            case "login":
                String login = params[1];
                String password = params[2];
                LoginInformation loginInformation = new LoginInformation();
                try {
                    loginInformation = httpClient.signIn(login, password);
                } catch (APIException e) {
                    e.printStackTrace();
                }
                return loginInformation;
        }
        return null;

    }

    @Override
    protected void onPostExecute(Object o) {
        if (o != null) {
            System.out.println(((LoginInformation) o).getLogin());
        }
        super.onPostExecute(o);
    }
}
