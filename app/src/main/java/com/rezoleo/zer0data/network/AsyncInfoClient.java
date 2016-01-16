package com.rezoleo.zer0data.network;

import android.content.Context;
import android.os.AsyncTask;

import com.rezoleo.zer0data.object.AllInformation;
import com.rezoleo.zer0data.toolbox.UI;

import fr.applicationcore.object.APIException;

/**
 * Created by Thomas on 9/01/16.
 */
public class AsyncInfoClient extends AsyncTask<String, Void, AllInformation> {
    private HttpClient httpClient = new HttpClient();
    private Context context;

    private AllInformation allInformation = new AllInformation();
    private APIException apiException = null;

    public AsyncInfoClient(Context context) {
        this.context = context;
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
                    allInformation.setPerson(httpClient.getOnePersonByLogin(attribute));
                } catch (APIException e) {
                    e.printStackTrace();
                    apiException = e;
                }
                break;
            case "card":
                try {
                    allInformation.setCard(httpClient.getOneCardByCode(attribute));
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
        } else if (allInformation.getCard() == null || allInformation.getCard().isEmpty()) {
            UI.openPopUp(context, "Erreur", "Une erreur est survenue");
        } else {
            System.out.println(allInformation.getCard());
        }
        if (apiException != null) {
            UI.openPopUp(context, "Erreur", apiException.getMsg().getMessage());
        } else if (allInformation.getPerson() == null || allInformation.getPerson().isEmpty()) {
            UI.openPopUp(context, "Erreur", "Une erreur est survenue");
        } else {
            System.out.println(allInformation.getPerson().getFirstname());
        }
        super.onPostExecute(allInformation);
    }
}
