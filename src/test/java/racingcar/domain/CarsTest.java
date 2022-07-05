package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @Test
    void Cars_이름들_입력받기() {
        //given, when
        Cars cars = new Cars("pobi,crong,honux");

        //then
        assertThat(cars.getCarList()).map(Car::getName).containsExactly("pobi", "crong", "honux");
    }
    @Test
    void Cars_이름_1개_입력시_예외던지기() {
        assertThatThrownBy(() -> new Cars("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1개의 자동차로는 경주를 할 수 없습니다.");
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
        assertThat(cars.getCarList()).map(Car::getPosition).containsExactly(1, 1, 1);
    }
    @Test
    void Cars_모두_정지() {
        //given
        Cars cars = new Cars("pobi,crong,honux");
        List<Car> carsList = cars.getCarList();
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
        assertThat(cars.getCarList()).map(Car::getPosition).containsExactly(0, 0, 0);
    }

    @Test
    void Cars_우승자_1명_구하기() {
        //given
        Cars cars = new Cars("pobi,crong,honux");

        //when
        cars.getCar(0).move(() -> true);
        cars.getCar(0).move(() -> true);
        cars.getCar(1).move(() -> true);
        List<String> winnerList = cars.getWinnerList();

        //then
        assertThat(winnerList).containsExactly("pobi");
    }

    @Test
    void Cars_우승자_2명이상_구하기() {
        //given
        Cars cars = new Cars("pobi,crong,honux");
        int num = 4;

        //when
        cars.getCar(0).move(() -> true);
        cars.getCar(1).move(() -> true);
        List<String> winnerList = cars.getWinnerList();

        //then
        assertThat(winnerList).containsExactly("pobi", "crong");
    }

    @Test
    void Cars_우승자_출력자료() {
        //given
        Cars cars = new Cars("pobi,crong,honux");

        //when
        cars.getCar(0).move(() -> true);
        cars.getCar(1).move(() -> true);

        String winners = cars.getWinners();

        //then
        assertThat(winners).isEqualTo("pobi, crong");
    }

    @Test
    void Cars_중복이름_예외() {
        assertThatThrownBy(() -> new Cars("pobi,pobi,honux"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름을 사용할 수 없습니다.");
    }
}
