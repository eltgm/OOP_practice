package ru.sultanyarov.library.mapper;

import lombok.experimental.UtilityClass;
import ru.sultanyarov.library.domain.Employer;
import ru.sultanyarov.library.domain.Reader;
import ru.sultanyarov.library.domain.UserDto;

@UtilityClass
public class UserMapper {
    public static Employer mapUserDtoToEmployer(UserDto userDto) {
        return Employer.builder()
                .position(userDto.getPosition())
                .id(userDto.getId())
                .fio(userDto.getFio())
                .password(userDto.getPassword())
                .username(userDto.getUsername())
                .birthDate(userDto.getBirthDate())
                .build();
    }

    public static Reader mapUserDtoToReader(UserDto userDto) {
        return Reader.builder()
                .id(userDto.getId())
                .fio(userDto.getFio())
                .username(userDto.getUsername())
                .birthDate(userDto.getBirthDate())
                .password(userDto.getPassword())
                .isBlocked(userDto.isBlocked())
                .sex(userDto.getSex())
                .resourcesInUse(userDto.getResourcesInUse())
                .resourcesInUseDto(userDto.getResourcesInUseDto())
                .build();
    }
}
