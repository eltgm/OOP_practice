package ru.sultanyarov.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import ru.sultanyarov.library.domain.CarrierType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResourceDto {
    @Id
    private String id;
    private CarrierType carrierType;
}
