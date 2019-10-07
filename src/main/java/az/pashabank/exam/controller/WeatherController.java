package az.pashabank.exam.controller;

import az.pashabank.exam.model.WeatherDto;
import az.pashabank.exam.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/weather/{id}")
    public void addWeatherInfo(@PathVariable Long id, @RequestBody WeatherDto weatherDto){
        weatherService.addWeatherInfo(id,weatherDto);
    }

    @GetMapping("/weather/{date}")
    public List<WeatherDto> getWeatherByDate(@PathVariable LocalDateTime date){
        return weatherService.getWeatherByDate(date);
    }

    @GetMapping("/weatherCity/{city}")
    public List<WeatherDto> getWeatherByCity(@PathVariable String city){
        return weatherService.getWeatherByCity(city);
    }

    @GetMapping("/weather/{date}/{city}")
    public List<WeatherDto> getWeatherByDateAndCity(@PathVariable LocalDateTime date,@PathVariable String city){
        return weatherService.getWeatherByDateAndCity(date,city);
    }
}
