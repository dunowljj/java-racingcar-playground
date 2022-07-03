package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;

    @Test
    void Car_이름_입력받기() {
        //given
        car = new Car("pobi");

        //when ,then
        assertThat("pobi").isEqualTo(car.getName());
    }

    @Test
    void Car_이동() {
        //given
        car = new Car("pobi");

        //when
        car.move(() -> true);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void Car_정지() {
        //given
        car = new Car("pobi");

        //when
        car.move(() -> false);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
