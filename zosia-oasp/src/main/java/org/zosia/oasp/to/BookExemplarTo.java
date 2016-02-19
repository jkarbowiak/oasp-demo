package org.zosia.oasp.to;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public abstract class BookExemplarTo {

    protected Long id;
    protected String serialNumber;

    protected BookExemplarTo(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    protected BookExemplarTo(Long id, String serialNumber) {
        this(serialNumber);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
