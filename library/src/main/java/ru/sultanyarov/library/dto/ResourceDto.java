package ru.sultanyarov.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sultanyarov.library.domain.Author;
import ru.sultanyarov.library.domain.CarrierType;
import ru.sultanyarov.library.domain.Genre;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDto {
    private String id;
    private String name;
    private LocalDate releaseDate;
    private boolean availability;
    private Author author;
    private Genre genre;
    private String content;
    private CarrierType carrierType;
    private int length;
    private double averageRate;
}
