package racingcar.view;


import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

    public void printTitle() {
        System.out.println("실행 결과");
    }

    public void printRace(Cars cars) {
        for (Car car : cars.getCarsList()) {
            printName(car);
            printPosition(car);
        }
        System.out.println();
    }
    private void printName(Car car) {
        System.out.print(car.getName()+" : ");
    }
    private void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public void printWinner(String names) {
        System.out.print(names+"가 최종 우승했습니다.");
    }
}
