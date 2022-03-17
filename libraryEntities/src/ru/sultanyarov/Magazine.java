package ru.sultanyarov;

public class Magazine extends PaperCarrier {
    @Override
    public String readCarrier() {
        System.out.println("Read from magazine...");
        return content;
    }
}
