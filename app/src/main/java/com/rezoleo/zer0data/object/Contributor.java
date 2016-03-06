package com.rezoleo.zer0data.object;

import java.util.Date;

import fr.applicationcore.object.APIObject;

/**
 * Created by Thomas on 8/01/16.
 */
public class Contributor extends fr.service_contributor.object.Contributor implements APIObject {
    protected boolean registered;

    public Contributor(String _id, String login, String creator, Date created, String creatorService, boolean registered) {
        super(_id, login, creator, created, creatorService);
        this.registered = registered;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean isEmpty() {
            return !this.registered;
        }
}
