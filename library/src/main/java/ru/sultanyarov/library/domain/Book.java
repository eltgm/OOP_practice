package ru.sultanyarov.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends PaperCarrier {
    public String readCarrier() {
        System.out.println("Read from book...");
        return this.content;
    }
}
