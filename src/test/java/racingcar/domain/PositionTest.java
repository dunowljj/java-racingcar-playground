package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @Test
    void Position_최초0() {
        //given
        Car car = new Car("pobi");

        //when, then
        assertThat(0).isEqualTo(car.getPosition());
    }
}
