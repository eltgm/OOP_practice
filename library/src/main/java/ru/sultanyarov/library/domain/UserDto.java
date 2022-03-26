package ru.sultanyarov.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import ru.sultanyarov.library.dto.ClientResourceDto;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String fio;
    private String username;
    private String password;
    private LocalDate birthDate;
    private String position;
    private boolean isBlocked;
    private Sex sex;
    private List<Authority> authorities;
    private List<ClientResourceDto> resourcesInUse;
    private List<Resource> resourcesInUseDto;
    private String _class;
}
