package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarsTest {

    @Test
    void cars_입력값_split(){
        //given
        String input = "pobi,crong,honux";

        //when
        Cars cars = new Cars(input);
        List<Car> carList = cars.getCarList();

        //then
        Assertions.assertThat(carList.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(carList.get(1).getName()).isEqualTo("crong");
        Assertions.assertThat(carList.get(2).getName()).isEqualTo("honux");
        }
    }
