package ru.sultanyarov.library.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DigitalCarrier extends Resource {
    private int length;

    @Override
    public String readCarrier() {
        return content;
    }

    @Override
    public CarrierType getCarrierType() {
        return CarrierType.DIGITAL;
    }
}
