package com.rezoleo.zer0data.network;

import android.content.Context;
import android.os.AsyncTask;

import com.rezoleo.zer0data.InformationActivity;
import com.rezoleo.zer0data.object.AllInformation;
import com.rezoleo.zer0data.toolbox.UI;

import fr.applicationcore.object.APIException;

/**
 * Created by Thomas on 9/01/16.
 */
public class AsyncInfoClient extends AsyncTask<String, Void, AllInformation> {
    private HttpClient httpClient = new HttpClient();
    private InformationActivity context;

    private AllInformation allInformation = new AllInformation();
    private APIException apiException = null;

    public AsyncInfoClient(Context context) {
        this.context = (InformationActivity) context;
    }

    @Override
    protected AllInformation doInBackground(String... params) {
        String mode = params[0];
        String attribute = params[1];

        allInformation = new AllInformation();
        apiException = null;

        switch (mode) {
            case "login":
                try {
                    getAllInformation(attribute);
                } catch (APIException e) {
                    e.printStackTrace();
                    apiException = e;
                }
                break;
            case "card":
                try {
                    getCard(attribute);
                    getAllInformation(allInformation.getCard().getOwner());
                } catch (APIException e) {
                    e.printStackTrace();
                    apiException = e;
                }
                break;
            default:
                break;
        }
        return allInformation;
    }

    @Override
    protected void onPostExecute(AllInformation allInformation) {
        if (apiException != null) {
            UI.openPopUp(context, "Erreur", apiException.getMsg().getMessage());
        } else if (allInformation == null) {
            UI.openPopUp(context, "Erreur", "Une erreur est survenue (Contributor)");
        } else {
            context.updateAllInformation(allInformation);
        }
        super.onPostExecute(allInformation);
    }

    private void getAllInformation(String login) throws APIException {
        allInformation.setPerson(httpClient.getOnePersonByLogin(login));
        try {
            allInformation.setContributor(httpClient.getOneContributorByLogin(login));
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

    private void getCard(String code) throws APIException {
        allInformation.setCard(httpClient.getOneCardByCode(code));
    }
}
