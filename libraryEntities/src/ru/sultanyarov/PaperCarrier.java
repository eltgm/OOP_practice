package ru.sultanyarov;

public abstract class PaperCarrier extends Resource {
    protected int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
