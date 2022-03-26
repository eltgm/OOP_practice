package ru.sultanyarov.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Flash extends DigitalCarrier {
    @Override
    public String readCarrier() {
        System.out.println("Read from flash...");
        return content;
    }
}
