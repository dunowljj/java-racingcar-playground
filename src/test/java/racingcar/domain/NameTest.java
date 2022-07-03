package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void 이름_5자초과_예외던짐() {
        assertThatThrownBy(() -> new Name("fdsafsd"))
                .isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
