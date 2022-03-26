package ru.sultanyarov.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@AllArgsConstructor
@Document(collection = "CD")
@EqualsAndHashCode(callSuper = true)
public class CD extends DigitalCarrier {
    public String readCarrier() {
        System.out.println("Read from CD...");
        return this.content;
    }
}
