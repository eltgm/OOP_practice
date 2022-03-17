package ru.sultanyarov;

public abstract class DigitalCarrier extends Resource {
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract boolean eraseCarrier();
}
