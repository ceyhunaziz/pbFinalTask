package az.pashabank.exam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherDto {

    private Double temperature;

    private LocalDateTime date = LocalDateTime.now();

    private Long cityId;
}
