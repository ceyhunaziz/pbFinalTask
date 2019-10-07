package az.pashabank.exam.dao;

import az.pashabank.exam.dao.model.CityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepo extends CrudRepository <CityEntity, Long >{
    List<CityEntity> findAll();

    CityEntity findByName(String name);
}
