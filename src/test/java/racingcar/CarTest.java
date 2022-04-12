package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp(){
        car = new Car("hello");
    }

    @Test
    void go_4이상_전진(){
        //given, when
        car.go();
    }

   /* @ValueSource(ints = {0,1,2,3})
    @ParameterizedTest
    void _4이하일_때_변화없음(int ran){

        car.go(ran);

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ValueSource(ints = {4,5,6,7,8,9})
    @ParameterizedTest
    void _4이상일_때_전진(int ran){

        car.go(ran);

        assertThat(car.getDistance()).isEqualTo(1);
    }*/
}
