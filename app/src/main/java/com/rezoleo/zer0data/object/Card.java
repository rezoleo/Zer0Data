package com.rezoleo.zer0data.object;

/**
 * Created by Thomas on 8/01/16.
 */
public class Card extends fr.applicationcore.object.APIObject {
    protected boolean registered;
    protected String code;
    protected String owner;
    protected String status;

    public String getCode() {
        return code;
    }

    public String getOwner() {
        return owner;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean isEmpty() {
        return !registered;
    }
}
