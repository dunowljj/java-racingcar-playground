package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @ValueSource(strings = {"abcdefg","abcdef","abcde12"})
    @ParameterizedTest
    void carName_입력값_길이_5초과_예외테스트(String input){
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 넘을 수 없습니다.");
    }
    @ValueSource(strings = {"abcde","abcd","abc"})
    @ParameterizedTest
    void carName_입력값_길이_5이하_테스트(String input){
        //when
        Car car = new Car(input);

        //then
        assertThat(car.getName()).isEqualTo(input);
    }
}
