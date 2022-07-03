package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void Car_이름_입력받기() {
        Car car = new Car("pobi");

        Assertions.assertThat("pobi").isEqualTo(car.getName());
    }
}
