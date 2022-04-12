package racingcar;

public class Car {
    private CarName name;
    private int distance = 0;

    public Car(String input) {
        name = new CarName(input);
    }

    public String getName() {
        return name.getName();
    }
    public int getDistance() {
        return distance;
    }

    public void go() {
        if(isMove()){
            distance++;
        }
    }
    private boolean isMove(){
        return (int)(Math.random() * 10) >= 4;
    }
}
