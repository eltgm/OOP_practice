package ru.sultanyarov.library.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document
@SuperBuilder
@RequiredArgsConstructor
public abstract class Resource {
    @Id
    protected String id;
    protected String name;
    protected LocalDate releaseDate;
    protected boolean availability;
    @DBRef
    protected Author author;
    @DBRef
    protected List<Review> resourceReviews;
    @DBRef
    protected Genre genre;
    protected String content;
    @Getter(value = AccessLevel.NONE)
    protected CarrierType carrierType;
    protected double avgRate;

    public abstract String readCarrier();

    public abstract CarrierType getCarrierType();
}
