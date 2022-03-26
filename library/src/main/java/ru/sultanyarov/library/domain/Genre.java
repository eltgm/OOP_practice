package ru.sultanyarov.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    private String id;
    private String name;
    private int ageLimit;
    private LocalDate firstMention;
    @DBRef
    private List<Resource> resourcesByGenre;
}
