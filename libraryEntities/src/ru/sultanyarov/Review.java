package ru.sultanyarov;

public class Review {
    private Reader reader;
    private Resource resource;
    private String comment;
    private int rate;

    public Review(Reader reader, Resource resource, String comment, int rate) {
        this.reader = reader;
        this.resource = resource;
        this.comment = comment;
        this.rate = rate;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
