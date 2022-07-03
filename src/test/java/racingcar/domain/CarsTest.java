package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @Test
    void Cars_이름들_입력받기() {
        //when
        Cars cars = new Cars("pobi,crong,honux");
        List<Car> carsList = cars.getCarsList();

        //given, then
        assertThat(carsList).map(Car::getName).contains("pobi", "crong", "honux");
    }

}
