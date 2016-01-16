package com.rezoleo.zer0data.network;

import android.os.AsyncTask;

import com.rezoleo.zer0data.common.Common;
import com.rezoleo.zer0data.object.LoginInformation;

import fr.applicationcore.object.APIException;

/**
 * Created by Thomas on 8/01/16.
 */
public class AsyncLoginClient extends AsyncTask<String, Void, LoginInformation> {
    private HttpClient httpClient = new HttpClient();

    @Override
    protected LoginInformation doInBackground(String... params) {
                String login = params[0];
                String password = params[1];
                LoginInformation loginInformation = new LoginInformation();
                try {
                    loginInformation = httpClient.signIn(login, password);
                } catch (APIException e) {
                    e.printStackTrace();
                }
                return loginInformation;
    }

    @Override
    protected void onPostExecute(LoginInformation o) {
        if (o != null) {
            System.out.println(o.getLogin());
        }
        super.onPostExecute(o);
    }
}
