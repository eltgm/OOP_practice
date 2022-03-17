package ru.sultanyarov;

import java.time.LocalDate;
import java.util.List;

public abstract class Resource {
    protected String name;
    protected LocalDate releaseDate;
    protected boolean availability;
    protected Author author;
    protected List<Review> resourceReviews;
    protected String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Review> getResourceReviews() {
        return resourceReviews;
    }

    public void setResourceReviews(List<Review> resourceReviews) {
        this.resourceReviews = resourceReviews;
    }

    public abstract String readCarrier();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
