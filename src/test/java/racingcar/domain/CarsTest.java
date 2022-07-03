package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @Test
    void Cars_이름들_입력받기() {
        //given
        Cars cars = new Cars("pobi,crong,honux");
        List<Car> carsList = cars.getCarsList();

        //when, then
        assertThat(carsList).map(Car::getName).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void Cars_모두_이동() {
        //given
        Cars cars = new Cars("pobi,crong,honux");
        int num = 4;


        //when 랜덤 숫자 자리에 임의의 숫자 4 대입
        cars.move(new RandomMovingStrategy() {
            @Override
            public boolean movable() {
                if (num >= FOWARD_NUM) {
                    return true;
                }
                return false;
            }
        });

        //then
        assertThat(cars.getCarsList()).map(Car::getPosition).containsExactly(1, 1, 1);
    }
    @Test
    void Cars_모두_정지() {
        //given
        Cars cars = new Cars("pobi,crong,honux");
        List<Car> carsList = cars.getCarsList();
        int num = 3;

        //when 랜덤 숫자 자리에 임의의 숫자 3 대입
        cars.move(new RandomMovingStrategy() {
            @Override
            public boolean movable() {
                if (num >= FOWARD_NUM) {
                    return true;
                }
                return false;
            }
        });

        //then
        assertThat(cars.getCarsList()).map(Car::getPosition).containsExactly(0, 0, 0);
    }

    @Test
    void Cars_우승자_1명_구하기() {
        //given
        Cars cars = new Cars("pobi,crong,honux");

        //when
        cars.getCar(0).move(() -> true);
        cars.getCar(0).move(() -> true);
        cars.getCar(1).move(() -> true);
        List<String> winners = cars.getWinnerList();

        //then
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void Cars_우승자_2명이상_구하기() {
        //given
        Cars cars = new Cars("pobi,crong,honux");
        int num = 4;

        //when
        cars.getCar(0).move(() -> true);
        cars.getCar(1).move(() -> true);
        List<String> winners = cars.getWinnerList();

        //then
        assertThat(winners).containsExactly("pobi", "crong");
    }
}
