package ru.sultanyarov.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaperCarrier extends Resource {
    protected int size;

    @Override
    public String readCarrier() {
        return content;
    }

    @Override
    public CarrierType getCarrierType() {
        return CarrierType.PAPER;
    }
}
