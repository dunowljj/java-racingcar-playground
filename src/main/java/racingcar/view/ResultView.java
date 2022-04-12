package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    public void showResult(List<Car> carsList){
        System.out.println("실행결과");
        for (int i = 0; i < carsList.size() ; i++) {
            showName(carsList, i);
            showDistance(carsList.get(i));
        }
    }

    private void showName(List<Car> carsList, int i) {
        System.out.print(carsList.get(i).getName() + " : ");
    }

    private void showDistance(Car car){
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
