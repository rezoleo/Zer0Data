package com.rezoleo.zer0data.object;

import java.util.SortedSet;

/**
 * Created by Thomas on 8/01/16.
 */
public class LoginInformation extends fr.applicationcore.object.APIObject {
    protected String login;
    protected String gate;
    protected SortedSet<String> roles;


    public String getLogin() {
        return login;
    }

    @Override
    public boolean isEmpty() {
        return login == null;
    }
}