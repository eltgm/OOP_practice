package ru.sultanyarov.library.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class User implements UserDetails {
    protected String id;
    protected String fio;
    protected String username;
    protected String password;
    protected LocalDate birthDate;
}
