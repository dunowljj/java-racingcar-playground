package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    StringAddCalculator addCal = new StringAddCalculator();

    @DisplayName("입력값이 기 구분자를 사용하는지 확인")
    @Test
    void isDefault(){
        //given
        String input = "//;\n5;3;4";
        boolean isDefault = addCal.checkInput(input);

        //then
        Assertions.assertThat(isDefault).isTrue();
    }

    @DisplayName("입력값이 커스텀 구분자를 사용하는지 확인")
    @Test
    void isCustom(){
        //given
        String input = "/3;3;2";

        //when
        boolean isCustom = addCal.checkInput(input);

        //then
        Assertions.assertThat(isCustom).isFalse();
    }
}
