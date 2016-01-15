package com.rezoleo.zer0data.object;

/**
 * Created by Thomas on 8/01/16.
 */
public class Contributor extends fr.service_contributor.object.Contributor {
    protected boolean registered;

    @Override
    public boolean isEmpty() {
        return registered;
    }
}
