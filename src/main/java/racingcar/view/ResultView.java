package racingcar.view;

import racingcar.Car;
import racingcar.Cars;

import java.util.List;

public class ResultView {

    public void showStartMessage() {
        System.out.println("실행결과");
    }
    public void showRace(Cars cars){
        List<Car> carsList = cars.getCarList();
        for (int i = 0; i < carsList.size(); i++) {
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


    public void showResult(Cars cars){
        List<Car> carsList = cars.getCarList();
        StringBuilder winners = getWinners(carsList);

        String result = winners.substring(0,winners.length()-2);

        System.out.print(result+"가 최종 우승했습니다.");
    }
    private StringBuilder getWinners(List<Car> carsList) {
        int maxDist = getDistanceOfWinner(carsList);
        return findWinnerByDistance(carsList, maxDist);
    }
    private int getDistanceOfWinner(List<Car> carsList) {
        int max = 0;
        for (Car car : carsList) {
            max = Math.max(car.getDistance(), max);
        }
        return max;
    }

    private StringBuilder findWinnerByDistance(List<Car> carsList, int maxDist) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < carsList.size(); i++) {
            answer = findWinenrs(carsList, maxDist, i, answer);
        }
        return answer;
    }
    private StringBuilder findWinenrs(List<Car> carsList, int max, int i, StringBuilder answer) {
        if(carsList.get(i).getDistance() == max){
            answer.append(carsList.get(i).getName()).append(", ");
        }
        return answer;
    }
}
