package com.rezoleo.zer0data.object;

/**
 * Created by Thomas on 8/01/16.
 */
public class Person extends fr.service_people.object.Person {
    protected boolean registered;

    @Override
    public boolean isEmpty() {
        return registered;
    }
}
