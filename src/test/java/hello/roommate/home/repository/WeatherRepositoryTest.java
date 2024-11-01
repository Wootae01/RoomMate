/*
package hello.roommate.home.repository;

import hello.roommate.home.domain.Weather;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@SpringBootTest
class WeatherRepositoryTest {
    @Autowired WeatherRepository repository;
    @Test
    void save() {
        Weather weather = new Weather("20241005", "1700", 20, 0, 0, 24, 15);
        Weather save = repository.save(weather);
        Assertions.assertThat(save).isEqualTo(weather);
    }

    @Test
    void findByFcstTime() {
        Weather weather = new Weather("20241005", "1700", 20, 0, 0, 24, 15);
        Weather save = repository.save(weather);

        Optional<Weather> optional = repository.findWeatherWithExtremesByDateAndTime("20241005", "1700");
        Weather find = optional.orElseThrow();

        Assertions.assertThat(find).isEqualTo(save);
    }

    @Test
    void update() {
        Weather weather = new Weather("20241005", "1700", 20, 0, 0, 24, 15);
        Weather save = repository.save(weather);
        Weather weather2 = new Weather("20241005", "1700", 18, 0, 0, 10, 21);
        repository.update(weather2);

        Optional<Weather> optional = repository.findWeatherWithExtremesByDateAndTime("20241005","1700");
        Weather find = optional.orElseThrow();
        Assertions.assertThat(find).isEqualTo(weather2);
    }
}
*/
