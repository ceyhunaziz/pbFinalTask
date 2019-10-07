package az.pashabank.exam.mapper;

import az.pashabank.exam.dao.model.CityEntity;
import az.pashabank.exam.model.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = WeatherMapper.class)
public abstract class CityMapper {
    public static final CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);


    @Mappings({
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "name",source = "name")
    })
    public abstract CityEntity cityDtoToEntity(CityDto cityDto);

    @Mappings({
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "weather",source = "weather")
    })
    public abstract CityDto cityDtoToEntity(CityEntity cityEntity);

    public abstract List<CityDto> listEntityToDto(List<CityEntity> cityEntityList);
}
