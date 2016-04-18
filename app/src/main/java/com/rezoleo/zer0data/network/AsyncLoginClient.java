package com.rezoleo.zer0data.network;

import android.content.Context;
import android.os.AsyncTask;

import com.rezoleo.zer0data.MainActivity;
import com.rezoleo.zer0data.object.GlobalState;
import com.rezoleo.zer0data.object.LoginInformation;
import com.rezoleo.zer0data.object.SesssionStatus;
import com.rezoleo.zer0data.toolbox.UI;

import fr.applicationcore.object.APIException;

/**
 * Created by Thomas on 8/01/16.
 */
public class AsyncLoginClient extends AsyncTask<String, Void, LoginInformation> {
    private HttpClient httpClient = new HttpClient();
    private MainActivity context;

    private APIException apiException = null;
    private LoginInformation loginInformation = null;

    public AsyncLoginClient(Context context) {
        this.context = (MainActivity) context;
    }

    @Override
    protected LoginInformation doInBackground(String... params) {
        String login = params[0];
        String password = params[1];
        apiException = null;
        loginInformation = null;
        try {
            loginInformation = httpClient.signIn(login, password);
        } catch (APIException e) {
            e.printStackTrace();
            apiException = e;
        }
        return loginInformation;
    }

    @Override
    protected void onPostExecute(LoginInformation loginInformation) {
        if (apiException != null) {
            UI.openPopUp(context, "Erreur", apiException.getMsg().getMessage(), true);
        } else if (loginInformation == null || loginInformation.getLogin() == null) {
            UI.openPopUp(context, "Erreur", "Une erreur est survenue", true);
        } else {
            GlobalState.checkAndReplace(null, SesssionStatus.connected);
            context.goToInformationActivity(loginInformation);
        }
        super.onPostExecute(loginInformation);
    }
}
