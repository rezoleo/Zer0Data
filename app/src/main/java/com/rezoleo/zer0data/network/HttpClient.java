package com.rezoleo.zer0data.network;

import com.rezoleo.zer0data.object.Card;
import com.rezoleo.zer0data.object.Login;
import com.rezoleo.zer0data.object.Person;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import fr.applicationcore.network.HttpMethod;
import fr.applicationcore.object.APIException;

/**
 * Created by Thomas on 8/01/16.
 */
public class HttpClient extends fr.applicationcore.network.ApplicationClient {
    public Login signIn(String login, String password) throws APIException {
        if (login == null || "".equals(login)) {
            return null;
        }
        String httpAddress = URL + "/api/login/" + login;
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("password", password));
        
        return accessLoginAuxi(HttpMethod.POST, httpAddress, urlParameters);
    }

    public Login signOut() throws APIException {
        String httpAddress = URL + "/api/login/";

        return accessLoginAuxi(HttpMethod.DELETE, httpAddress, null);
    }

    public Card getOneCardByCode(String code) throws APIException {
        if(code==null || code.equals("")){
            return null;
        }

        String httpAddress=URL+"/api/card/code/"+code;

        return this.accessCardAuxi(HttpMethod.GET, httpAddress, null);
    }

    /*protected Person accessPersonAuxi(HttpMethod method, String httpAddress, List<NameValuePair> urlParameters) throws APIException {
        try{
            Person Person = (Person) this.requestOne(method, Person.class, httpAddress, urlParameters, null);
            if(Person==null || Person.get_id()==null){
                throw new APIException();
            }
            return Person;
        }
        catch (APIException e){
            throw e;
        }
    }*/

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

    protected Login accessLoginAuxi(HttpMethod method, String httpAddress, List<NameValuePair> urlParameters) throws APIException {
        try{
            Login login = (Login) this.requestOne(method, Login.class, httpAddress, urlParameters, null);
            if(login==null || login.isEmpty()){
                throw new APIException();
            }
            return login;
        }
        catch (APIException e){
            throw e;
        }
    }
}
