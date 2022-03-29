package calculator;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {
    StringAddCalculator addCal = new StringAddCalculator();



    @Test
    void splitAndSum_커스텀_구분자() throws Exception{
        //given
        String input = "//;\n5;3;4";

        //when
        int result = addCal.splitAndSum(input);

        //then
        assertThat(result).isEqualTo(5 + 3 + 4);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception{
        //given
        String input = "5:3,1:4:1,1";

        //when
        int result = addCal.splitAndSum(input);

        //then
        assertThat(result).isEqualTo(5 + 3 + 1 + 4 + 1 + 1);
    }

    @Test
    void splitAndSum_쉼표_구분자() throws Exception{
        //given
        String input = "5,3,4,1";

        //when
        int result = addCal.splitAndSum(input);

        //then
        assertThat(result).isEqualTo(5 + 3 + 4 + 1);
    }

    @Test
    void splitAndSum_콜론_구분자() throws Exception{
        //given
        String input = "5:1:1";

        //when
        int result = addCal.splitAndSum(input);

        //then
        assertThat(result).isEqualTo(5 + 1 + 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//!\n5!3!-4", "//;\n-5;3;4", "//;\n5;-1;3;4", "5,-3,1", "-1,3,3,2", "1,3,3,-2"})
    void splitAndSum_음수_예외(String input){
        //when

        assertThatThrownBy(() -> addCal.splitAndSum(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("음수는 계산할 수 없습니다.");
    }
    @ParameterizedTest
    @ValueSource(strings = {"//!\n5;3!4", "//;\n5+3+4", "//;\n5;1;3/4", "5,3+1", "1+3,3,2", "1,3+3,2"})
    void splitAndSum_잘못된_입력_예외(String input){
        assertThatThrownBy(() -> addCal.splitAndSum(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("입력이 잘못되었습니다.");
    }
    @ParameterizedTest
    @ValueSource(strings = {"//!\n5;3!4", "//;\n5+3+4", "//;\n5;1;3/4", "5,3+1", "1+3,3,2", "1,3+3,2"})
    void splitAndSum_빈문자와_null(String input){

    }
    @ParameterizedTest
    @ValueSource(strings = {"//!\n5;3!4", "//;\n5+3+4", "//;\n5;1;3/4", "5,3+1", "1+3,3,2", "1,3+3,2"})
    void splitAndSum_숫자_하나(String input){

    }
    @Test
    void isSymbol_기호일때(){
        //given
        String input = "//;\n5;3;4";

        //when
        boolean isSymbol = addCal.isSymbol(input);

        //then
        assertThat(isSymbol).isTrue();
    }
    @Test
    void isSymbol_기호_아닐때(){
        //given
        String input = "//a\n5;3;4";

        //when
        boolean isSymbol = addCal.isSymbol(input);

        //then
        assertThat(isSymbol).isFalse();
    }

    @DisplayName("getType_입력값이 커스텀 구분자를 사용 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n5;3;4","//A\n5;3;4","//3\n5;3;4","//f\n5;3;4"})
    void getType_CUSTOM(String input){
        //when
        CalcType calcType = addCal.getType(input);
        //then
        assertThat(calcType).isEqualTo(CalcType.CUSTOM);
    }

    @DisplayName("getType_입력값이 ,|: 구분자를 사용 테스트")
    @Test
    void getType_DEFAULT(){
        //given
        String input = "5:3,1:4,1,1";

        //when
        CalcType calcType = addCal.getType(input);

        //then
        assertThat(calcType).isEqualTo(CalcType.DEFAULT);
    }
}
