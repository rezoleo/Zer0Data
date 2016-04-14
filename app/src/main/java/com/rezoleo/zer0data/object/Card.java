package com.rezoleo.zer0data.object;

import java.util.Date;

/**
 * Created by Thomas on 8/01/16.
 */
public class Card extends fr.service_card.object.Card implements fr.applicationcore.object.APIObject {
    protected boolean registered;

    public Card(String _id, String owner, String code, String status, String creator, Date created, String creatorService, String updator, Date updated, String updatorService, boolean registered) {
        super(_id, owner, code, status, creator, created, creatorService, updator, updated, updatorService);
        this.registered = registered;
    }

    @Override
    public boolean isEmpty() {
        return !this.registered;
    }
}
