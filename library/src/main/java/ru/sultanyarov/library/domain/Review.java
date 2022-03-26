package ru.sultanyarov.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import ru.sultanyarov.library.dto.ResourceDto;

@Data
@Builder
@AllArgsConstructor
public class Review {
    private String id;
    @DBRef
    private Reader reader;
    private ResourceDto resource;
    private String comment;
    private int rate;
}
