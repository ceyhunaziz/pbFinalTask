package az.pashabank.exam.mapper;

import az.pashabank.exam.dao.model.CityEntity;
import az.pashabank.exam.dao.model.WeatherEntity;
import az.pashabank.exam.model.CityDto;
import az.pashabank.exam.model.WeatherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public abstract class WeatherMapper {
    public static final WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mappings({
            @Mapping(target = "temperature",source = "temperature"),
            @Mapping(target = "date",source = "date"),
            @Mapping(target = "cityId",source = "city.id")
    })
    public abstract WeatherDto weahterEntityToDto(WeatherEntity weatherEntity);

    @Mappings({
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "temperature",source = "temperature"),
            @Mapping(target = "date",source = "date"),
            @Mapping(target = "city",ignore = true)
    })
    public abstract WeatherEntity weatherDtoToEntity(WeatherDto weatherDto);

    public abstract List<WeatherDto> listEntityToDto(List<WeatherEntity> cityEntityList);
}
