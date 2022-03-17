package ru.sultanyarov;

public class Flash extends DigitalCarrier {
    @Override
    public boolean eraseCarrier() {
        this.content = null;
        return true;
    }

    @Override
    public String readCarrier() {
        System.out.println("Read from flash...");
        return content;
    }
}
