package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void Position_최초0() {
        Car car = new Car("pobi");

        Assertions.assertThat(0).isEqualTo(car.getPosition());
    }
}
