package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @Test
    void Position_최초0() {
        //when
        Car car = new Car("pobi");

        //given, then
        assertThat(0).isEqualTo(car.getPosition());
    }
}
