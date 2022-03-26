package ru.sultanyarov.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Sex {
    M("M"),
    W("W");

    private final String value;
}
