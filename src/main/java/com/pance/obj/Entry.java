package com.pance.obj;

import java.util.Date;

public class Entry {

    private final Date createdDate;
    private final String value;

    public Entry(Date createdDate, String value) {
        this.createdDate = createdDate;
        this.value = value;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getValue() {
        return value;
    }
}
