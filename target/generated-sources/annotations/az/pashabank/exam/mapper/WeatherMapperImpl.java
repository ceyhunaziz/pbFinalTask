package az.pashabank.exam.mapper;

import az.pashabank.exam.dao.model.CityEntity;
import az.pashabank.exam.dao.model.WeatherEntity;
import az.pashabank.exam.dao.model.WeatherEntity.WeatherEntityBuilder;
import az.pashabank.exam.model.WeatherDto;
import az.pashabank.exam.model.WeatherDto.WeatherDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-07T17:02:00+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
public class WeatherMapperImpl extends WeatherMapper {

    @Override
    public WeatherDto weahterEntityToDto(WeatherEntity weatherEntity) {
        if ( weatherEntity == null ) {
            return null;
        }

        WeatherDtoBuilder weatherDto = WeatherDto.builder();

        weatherDto.date( weatherEntity.getDate() );
        weatherDto.temperature( weatherEntity.getTemperature() );
        weatherDto.cityId( weatherEntityCityId( weatherEntity ) );

        return weatherDto.build();
    }

    @Override
    public WeatherEntity weatherDtoToEntity(WeatherDto weatherDto) {
        if ( weatherDto == null ) {
            return null;
        }

        WeatherEntityBuilder weatherEntity = WeatherEntity.builder();

        weatherEntity.date( weatherDto.getDate() );
        weatherEntity.temperature( weatherDto.getTemperature() );

        return weatherEntity.build();
    }

    @Override
    public List<WeatherDto> listEntityToDto(List<WeatherEntity> cityEntityList) {
        if ( cityEntityList == null ) {
            return null;
        }

        List<WeatherDto> list = new ArrayList<WeatherDto>( cityEntityList.size() );
        for ( WeatherEntity weatherEntity : cityEntityList ) {
            list.add( weahterEntityToDto( weatherEntity ) );
        }

        return list;
    }

    private Long weatherEntityCityId(WeatherEntity weatherEntity) {
        if ( weatherEntity == null ) {
            return null;
        }
        CityEntity city = weatherEntity.getCity();
        if ( city == null ) {
            return null;
        }
        Long id = city.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
