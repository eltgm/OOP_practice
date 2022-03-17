package ru.sultanyarov;

public enum Sex {
    M("M"),
    W("W");

    private final String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
