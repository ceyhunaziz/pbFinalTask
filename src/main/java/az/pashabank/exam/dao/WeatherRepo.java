package az.pashabank.exam.dao;

import az.pashabank.exam.dao.model.CityEntity;
import az.pashabank.exam.dao.model.WeatherEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherRepo extends CrudRepository <WeatherEntity, Long>{
    List<WeatherEntity> findAllByDate(LocalDateTime localDateTime);
    List<WeatherEntity> findAllByDateAndCity( String city,LocalDateTime date);
}
