package racingcar;

public class Car {
    private CarName name;
    private int distance;

    public Car(String input) {
        name = new CarName(input);
    }

    public String getName() {
        return name.getName();
    }
    public int getDistance() {
        return distance;
    }
}
