package com.rezoleo.zer0data.object;

/**
 * Created by Thomas on 16/01/16.
 */
public class AllInformation {
    private Card card;
    private Contributor contributor;
    private Person person;

    public AllInformation() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
