package drabek.jaroslaw.common;

import java.util.Date;

public class Event {
    private final String party;
    private final Date date;

    public Event(String party, Date date) {
        this.party = party;
        this.date = date;
    }

    public String getParty() {
        return party;
    }

    public Date getDate() {
        return date;
    }
}
