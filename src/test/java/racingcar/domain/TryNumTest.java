package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryNumTest {

    @ParameterizedTest
    @ValueSource(ints = {-1,-99,0})
    void TryNum_시도횟수_0이하_예외던지기(int input) {
        Assertions.assertThatThrownBy(() -> new TryNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 정수를 입력해주세요.");
    }
}