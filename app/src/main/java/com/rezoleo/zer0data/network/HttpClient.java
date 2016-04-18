package com.rezoleo.zer0data.network;

import com.rezoleo.zer0data.common.Common;
import com.rezoleo.zer0data.object.Card;
import com.rezoleo.zer0data.object.Contributor;
import com.rezoleo.zer0data.object.LoginInformation;
import com.rezoleo.zer0data.object.Person;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import fr.applicationcore.network.HttpMethod;
import fr.applicationcore.object.APIException;
import fr.applicationcore.toolbox.CheckAttributes;

/**
 * Created by Thomas on 8/01/16.
 */
public class HttpClient extends fr.applicationcore.network.ApplicationClient {
    public HttpClient() {
        super();
        setURL(Common.URL);
        setUserAgent("Android");
    }

    public LoginInformation signIn(String login, String password) throws APIException {
        CheckAttributes.isEmptyThrowsError(login);
        CheckAttributes.checkRegexThrowsError(login);

        String httpAddress = URL + "/api/login/" + login;
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("password", password));
        
        return accessLoginAuxi(HttpMethod.POST, httpAddress, urlParameters);
    }

    public LoginInformation signOut() throws APIException {
        String httpAddress = URL + "/api/login/";

        return accessLoginAuxi(HttpMethod.DELETE, httpAddress, null);
    }

    public Card getOneCardByCode(String code) throws APIException {
        CheckAttributes.isEmptyThrowsError(code);
        CheckAttributes.checkRegexThrowsError(code);

        String httpAddress=URL+"/api/card/"+code;

        return this.accessCardAuxi(HttpMethod.GET, httpAddress, null);
    }

    public Person getOnePersonByLogin(String login) throws APIException{
        CheckAttributes.isEmptyThrowsError(login);
        CheckAttributes.checkRegexThrowsError(login);

        String http_adress=URL+"/api/people/"+login;

        return this.accessPersonAuxi(HttpMethod.GET, http_adress, null);
    }

    public Contributor getOneContributorByLogin(String login) throws APIException {
        CheckAttributes.isEmptyThrowsError(login);
        CheckAttributes.checkRegexThrowsError(login);

        String http_address = URL + "/api/contributor/" + login;

        return this.accessContributorAuxi(HttpMethod.GET, http_address, null);
    }

    /* Auxiliary functions */
    protected Card accessCardAuxi(HttpMethod method, String httpAddress, List<NameValuePair> urlParameters) throws APIException {
        try{
            Card card = (Card) this.requestOne(method, Card.class, httpAddress, urlParameters, null);
            if(card==null || card.isEmpty()){
                throw new APIException();
            }
            return card;
        }
        catch (APIException e){
            throw e;
        }
    }

    protected Person accessPersonAuxi(HttpMethod method, String httpAddress, List<NameValuePair> urlParameters) throws APIException {
        try{
            Person Person = (Person) this.requestOne(method, Person.class, httpAddress, urlParameters, null);
            if(Person==null || Person.isEmpty()){
                throw new APIException();
            }
            return Person;
        }
        catch (APIException e){
            throw e;
        }
    }

    protected LoginInformation accessLoginAuxi(HttpMethod method, String httpAddress, List<NameValuePair> urlParameters) throws APIException {
        try{
            LoginInformation login = (LoginInformation) this.requestOne(method, LoginInformation.class, httpAddress, urlParameters, null);
            if(login==null || login.isEmpty()){
                throw new APIException();
            }
            return login;
        }
        catch (APIException e){
            throw e;
        }
    }

    protected Contributor accessContributorAuxi(HttpMethod method, String httpAddress, List<NameValuePair> urlParameters) throws APIException {
        try {
            Contributor contributor = (Contributor) this.requestOne(method, Contributor.class, httpAddress, urlParameters, null);
            if (contributor == null || contributor.isEmpty()) {
                throw new APIException();
            }
            return contributor;
        } catch (APIException e) {
            throw e;
        }
    }
}
