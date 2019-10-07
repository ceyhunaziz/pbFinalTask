package az.pashabank.exam.scheduler;

import az.pashabank.exam.model.WeatherDto;
import az.pashabank.exam.service.WeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class WeatherScheduler {

    private final WeatherService weatherService;

    public WeatherScheduler(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(cron = "0,10 * * * * *")
    public void cronJob(){
        Long cityId = getRandom(1L,5L);
        weatherService.addWeatherInfo(cityId, WeatherDto.builder().cityId(cityId)
                .temperature((double)getRandom(15L,35L)).date(LocalDateTime.now()).build());
    }

    private Long getRandom(Long from, Long to){
        return ThreadLocalRandom.current().nextLong(from,to);
    }
}
