package az.pashabank.exam.service;

import az.pashabank.exam.dao.CityRepo;
import az.pashabank.exam.dao.WeatherRepo;
import az.pashabank.exam.dao.model.CityEntity;
import az.pashabank.exam.dao.model.WeatherEntity;
import az.pashabank.exam.exception.CityException;
import az.pashabank.exam.mapper.WeatherMapper;
import az.pashabank.exam.model.WeatherDto;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    private final WeatherRepo weatherRepo;
    private final CityRepo cityRepo;

    public WeatherService(WeatherRepo weatherRepo, CityRepo cityRepo) {
        this.weatherRepo = weatherRepo;
        this.cityRepo = cityRepo;
    }

    public List<WeatherDto> getWeatherByDate(LocalDateTime localDateTime) {
        List<WeatherEntity> weatherEntities = weatherRepo.findAllByDate(localDateTime);
        return WeatherMapper.INSTANCE.listEntityToDto(weatherEntities);
    }

    public List<WeatherDto> getWeatherByCity(String name) {
        CityEntity cityEntity = cityRepo.findByName(name);
        return WeatherMapper.INSTANCE.listEntityToDto(cityEntity.getWeather());
    }

    public List<WeatherDto> getWeatherByDateAndCity(LocalDateTime date, String city) {
        List<WeatherEntity> allByDateAndCity = weatherRepo
                .findAllByDateAndCity(city,date);
        return WeatherMapper.INSTANCE.listEntityToDto(allByDateAndCity);
    }

    public void addWeatherInfo(Long id, WeatherDto weatherDto) {
        CityEntity city = cityRepo.findById(id).orElseThrow(() -> new CityException("There id no city with such Id"));

        WeatherEntity weatherEntity = WeatherMapper.INSTANCE.weatherDtoToEntity(weatherDto);

        weatherEntity.setCity(city);

        city.getWeather().add(weatherEntity);

        cityRepo.save(city);
    }
}
