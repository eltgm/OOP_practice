package ru.sultanyarov.library.mapper;

import lombok.experimental.UtilityClass;
import ru.sultanyarov.library.domain.CarrierType;
import ru.sultanyarov.library.domain.DigitalCarrier;
import ru.sultanyarov.library.domain.PaperCarrier;
import ru.sultanyarov.library.domain.Resource;
import ru.sultanyarov.library.dto.ResourceDto;

import java.util.ArrayList;
import java.util.List;

import static ru.sultanyarov.library.domain.CarrierType.DIGITAL;
import static ru.sultanyarov.library.domain.CarrierType.PAPER;

@UtilityClass
public class ResourceMapper {
    public static ResourceDto mapPaperResourceToResourceDto(PaperCarrier resource) {
        return ResourceDto.builder()
                .author(resource.getAuthor())
                .availability(resource.isAvailability())
                .content(resource.getContent())
                .id(resource.getId())
                .genre(resource.getGenre())
                .name(resource.getName())
                .releaseDate(resource.getReleaseDate())
                .carrierType(PAPER)
                .length(resource.getSize())
                .averageRate(resource.getAvgRate())
                .build();
    }

    public static ResourceDto mapDigitalResourceToResourceDto(DigitalCarrier resource) {
        return ResourceDto.builder()
                .author(resource.getAuthor())
                .availability(resource.isAvailability())
                .content(resource.getContent())
                .id(resource.getId())
                .genre(resource.getGenre())
                .name(resource.getName())
                .releaseDate(resource.getReleaseDate())
                .carrierType(DIGITAL)
                .length(resource.getLength())
                .averageRate(resource.getAvgRate())
                .build();
    }

    public static Resource mapDtoToDomainResource(ResourceDto resourceDto) {
        Resource resource = null;

        CarrierType carrierType = resourceDto.getCarrierType();

        switch (carrierType) {
            case DIGITAL:
                resource = DigitalCarrier.builder()
                        .id(resourceDto.getId())
                        .name(resourceDto.getName())
                        .releaseDate(resourceDto.getReleaseDate())
                        .availability(resourceDto.isAvailability())
                        .author(resourceDto.getAuthor())
                        .genre(resourceDto.getGenre())
                        .content(resourceDto.getContent())
                        .carrierType(carrierType)
                        .length(resourceDto.getLength())
                        .avgRate(resourceDto.getAverageRate())
                        .build();
                break;
            case PAPER:
                resource = PaperCarrier.builder()
                        .id(resourceDto.getId())
                        .name(resourceDto.getName())
                        .releaseDate(resourceDto.getReleaseDate())
                        .availability(resourceDto.isAvailability())
                        .author(resourceDto.getAuthor())
                        .genre(resourceDto.getGenre())
                        .content(resourceDto.getContent())
                        .carrierType(carrierType)
                        .size(resourceDto.getLength())
                        .avgRate(resourceDto.getAverageRate())
                        .build();
                break;
        }

        return resource;
    }

    public static ResourceDto mapResourceDtoToDomain(CarrierType carrierTypeEnum, Resource resourceById) {
        ResourceDto resourceDto = null;

        switch (carrierTypeEnum) {
            case DIGITAL:
                resourceDto = mapDigitalResourceToResourceDto((DigitalCarrier) resourceById);
                break;
            case PAPER:
                resourceDto = mapPaperResourceToResourceDto((PaperCarrier) resourceById);
                break;
        }
        return resourceDto;
    }

    public static List<ResourceDto> mapResourcesToResourcesDto(List<Resource> resources) {
        List<ResourceDto> resourceDtos = new ArrayList<>(resources.size());

        for (Resource resource : resources) {
            switch (resource.getCarrierType()) {
                case DIGITAL:
                    resourceDtos.add(mapDigitalResourceToResourceDto((DigitalCarrier) resource));
                    break;
                case PAPER:
                    resourceDtos.add(mapPaperResourceToResourceDto((PaperCarrier) resource));
                    break;
            }
        }

        return resourceDtos;
    }
}
