package com.pance.obj;

import java.util.Date;

public class Category {

    private final Date createdDate;
    private final String name;

    public Category(Date createdDate, String name) {
        this.createdDate = createdDate;
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getName() {
        return name;
    }
}
