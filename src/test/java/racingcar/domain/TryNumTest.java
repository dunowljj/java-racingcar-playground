package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TryNumTest {

    @Test
    void TryNum_String입력_저장() {
        //given
        String input = "3";

        //when
        TryNum tryNum = new TryNum(input);

        //then
        assertThat(tryNum.getTryNum()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","-99","0"})
    void TryNum_시도횟수_0이하_예외던지기(String input) {
        assertThatThrownBy(() -> new TryNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 정수를 입력해주세요.");
    }
}