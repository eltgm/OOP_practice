package ru.sultanyarov;

public class CD extends DigitalCarrier {
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String readCarrier() {
        System.out.println("Read from CD...");
        return this.content;
    }

    public boolean eraseCarrier() {
        this.content = null;
        return true;
    }
}
