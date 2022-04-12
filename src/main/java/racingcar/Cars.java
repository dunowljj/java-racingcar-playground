package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> carList;
    public Cars(String input) {
        carList = new ArrayList<>();

        String[] cars = input.split(",");
        for(String carName : cars){
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}