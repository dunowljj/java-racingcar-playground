package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        cars = new ArrayList<>();
        String[] names = carNames.split(",");

        for (String name : names) {
            cars.add(new Car(name));
        }
        if (cars.size() == 1) {
            throw new IllegalArgumentException("1개의 자동차로는 경주를 할 수 없습니다.");
        }
    }

    public void move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public String getWinners() {
        List<String> winnerList = getWinnerList();
        StringBuilder names = new StringBuilder();
        for (String winner : winnerList) {
            names.append(winner).append(", ");
        }
        names.deleteCharAt(names.lastIndexOf(","));
        return names.toString().trim();
    }
    protected List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();

        return findWinners(winnerList, maxPosition);
    }
    private List<String> findWinners(List<String> winnerList, int maxPosition) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }


    public List<Car> getCarsList() {
        return cars;
    }

    public Car getCar(int i) {
        return cars.get(i);
    }
}
