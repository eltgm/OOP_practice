package ru.sultanyarov;

public class Book extends PaperCarrier {
    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String readCarrier() {
        System.out.println("Read from book...");
        return this.content;
    }
}
