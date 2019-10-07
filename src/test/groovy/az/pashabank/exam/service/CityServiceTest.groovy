package az.pashabank.exam.service

import az.pashabank.exam.dao.CityRepo
import az.pashabank.exam.dao.model.CityEntity
import az.pashabank.exam.model.CityDto
import spock.lang.Specification

class CityServiceTest extends Specification {

    CityRepo cityRepo
    CityService cityService

    void setup() {
        cityRepo = Mock()
        cityService = new CityService(cityRepo)
    }

    def "GetAllCities"() {
        given:
        CityEntity cityEntity = CityEntity.builder().build()
        List<CityEntity> cityEntities= Arrays.asList(cityEntity)
        when:
        List<CityDto> cityDtoList = cityService.getAllCities()
        then:
        1* cityRepo.findAll() >> cityEntities
        cityEntities.get(0).getName() == cityDtoList.get(0).getName()
    }
}
