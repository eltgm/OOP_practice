package ru.sultanyarov;

import java.time.LocalDate;
import java.util.List;

public class Genre {
    private String name;
    private int ageLimit;
    private LocalDate firstMention;
    private List<Resource> resourcesByGenre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public LocalDate getFirstMention() {
        return firstMention;
    }

    public void setFirstMention(LocalDate firstMention) {
        this.firstMention = firstMention;
    }

    public List<Resource> getResourcesByGenre() {
        return this.resourcesByGenre;
    }
}
