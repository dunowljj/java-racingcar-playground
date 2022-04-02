package racingcar;

public class CarName {
    public static final int MAX_NAME_LENGTH_OF_CAR = 5;
    String name;

    public CarName(String name) {
        if(name.length() > MAX_NAME_LENGTH_OF_CAR){
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
