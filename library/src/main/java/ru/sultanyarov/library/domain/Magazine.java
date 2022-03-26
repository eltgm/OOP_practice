package ru.sultanyarov.library.domain;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
public class Magazine extends PaperCarrier {
    @Override
    public String readCarrier() {
        System.out.println("Read from magazine...");
        return content;
    }
}
