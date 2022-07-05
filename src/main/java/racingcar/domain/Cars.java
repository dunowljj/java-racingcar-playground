package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> carList;

    public Cars(String carNames) {
        carList = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
        if (isNameAlone()) {
            throw new IllegalArgumentException("1개의 자동차로는 경주를 할 수 없습니다.");
        }
        if (isNameOverlapped()) {
            throw new IllegalArgumentException("중복된 이름을 사용할 수 없습니다.");
        }
    }
    private boolean isNameAlone() {
        return carList.size() == 1;
    }
    private boolean isNameOverlapped(){
        return carList.size() != getDistinctSet().size();
    }
    private Set<String> getDistinctSet() {
        Set<String> set = new HashSet<>();
        for (Car car : carList) {
            set.add(car.getName());
        }
        return set;
    }

    public void move(MovingStrategy movingStrategy) {
        for (Car car : carList) {
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
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }




    public List<Car> getCarList() {
        return carList;
    }

    public Car getCar(int i) {
        return carList.get(i);
    }
}
