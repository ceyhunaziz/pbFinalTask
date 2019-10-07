package az.pashabank.exam.service;

import az.pashabank.exam.dao.CityRepo;
import az.pashabank.exam.dao.model.CityEntity;
import az.pashabank.exam.mapper.CityMapper;
import az.pashabank.exam.model.CityDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepo cityRepo;

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }


    public List<CityDto> getAllCities() {
        List<CityEntity> cityEntities = cityRepo.findAll();
        return CityMapper.INSTANCE.listEntityToDto(cityEntities);
    }
}
