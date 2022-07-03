package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void Car_이름_입력받기() {
        //when
        Car car = new Car("pobi");

        //given ,then
        assertThat("pobi").isEqualTo(car.getName());
    }
}
