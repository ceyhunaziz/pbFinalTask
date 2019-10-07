package az.pashabank.exam.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "weather", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Long id;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();

    @JoinColumn(name = "city_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private CityEntity city;
}
