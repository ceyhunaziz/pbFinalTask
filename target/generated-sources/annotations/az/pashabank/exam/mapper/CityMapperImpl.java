package az.pashabank.exam.mapper;

import az.pashabank.exam.dao.model.CityEntity;
import az.pashabank.exam.dao.model.CityEntity.CityEntityBuilder;
import az.pashabank.exam.dao.model.WeatherEntity;
import az.pashabank.exam.model.CityDto;
import az.pashabank.exam.model.CityDto.CityDtoBuilder;
import az.pashabank.exam.model.WeatherDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-07T17:02:00+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
public class CityMapperImpl extends CityMapper {

    private final WeatherMapper weatherMapper = Mappers.getMapper( WeatherMapper.class );

    @Override
    public CityEntity cityDtoToEntity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        CityEntityBuilder cityEntity = CityEntity.builder();

        cityEntity.name( cityDto.getName() );
        cityEntity.weather( weatherDtoListToWeatherEntityList( cityDto.getWeather() ) );

        return cityEntity.build();
    }

    @Override
    public CityDto cityDtoToEntity(CityEntity cityEntity) {
        if ( cityEntity == null ) {
            return null;
        }

        CityDtoBuilder cityDto = CityDto.builder();

        cityDto.name( cityEntity.getName() );
        cityDto.weather( weatherMapper.listEntityToDto( cityEntity.getWeather() ) );

        return cityDto.build();
    }

    @Override
    public List<CityDto> listEntityToDto(List<CityEntity> cityEntityList) {
        if ( cityEntityList == null ) {
            return null;
        }

        List<CityDto> list = new ArrayList<CityDto>( cityEntityList.size() );
        for ( CityEntity cityEntity : cityEntityList ) {
            list.add( cityDtoToEntity( cityEntity ) );
        }

        return list;
    }

    protected List<WeatherEntity> weatherDtoListToWeatherEntityList(List<WeatherDto> list) {
        if ( list == null ) {
            return null;
        }

        List<WeatherEntity> list1 = new ArrayList<WeatherEntity>( list.size() );
        for ( WeatherDto weatherDto : list ) {
            list1.add( weatherMapper.weatherDtoToEntity( weatherDto ) );
        }

        return list1;
    }
}
