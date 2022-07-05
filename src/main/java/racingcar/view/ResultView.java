package racingcar.view;


import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printRace(Cars cars) {
        for (Car car : cars.getCarList()) {
            printName(car);
            printPosition(car);
        }
        System.out.println();
    }
    private static void printName(Car car) {
        System.out.print(car.getName()+" : ");
    }
    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(String names) {
        System.out.print(names+"(이)가 최종 우승했습니다.");
    }
}
