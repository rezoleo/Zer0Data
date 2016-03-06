package com.rezoleo.zer0data.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;

import java.util.Date;
import java.util.SortedSet;

import fr.applicationcore.object.APIObject;

/**
 * Created by Thomas on 8/01/16.
 */
public class Person extends fr.service_people.object.Person implements APIObject {
    @Expose
    @Since(1.0D)
    protected boolean registered;

    public Person() {
    }

    public Person(String _id, String login, String lastname, String firstname, String sex, Date birthdate, boolean major, String mail, String tel, String picture, SortedSet<String> tags, String creator, Date created, String creatorService, String updator, Date updated, String updatorService, boolean registered) {
        super(_id, login, lastname, firstname, sex, birthdate, major, mail, tel, picture, tags, creator, created, creatorService, updator, updated, updatorService);
        this.registered = registered;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public boolean isEmpty() {
        return !this.registered;
    }
}
