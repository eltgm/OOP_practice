package ru.sultanyarov.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Transient;

@Getter
@RequiredArgsConstructor
public enum CarrierType {
    DIGITAL("DIGITAL", "Цифровой", DigitalCarrier.class),
    PAPER("PAPER", "Бумажный", PaperCarrier.class);

    private final String value;
    @Transient
    private final String russianCarrierTypeValue;
    @Transient
    private final Class<? extends Resource> carrierResource;
}
