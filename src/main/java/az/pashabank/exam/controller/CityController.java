package az.pashabank.exam.controller;

import az.pashabank.exam.model.CityDto;
import az.pashabank.exam.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<CityDto> getAllCities(){
       return cityService.getAllCities();
    }
}
