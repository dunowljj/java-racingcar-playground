package racingcar.domain;


public class Car {
    private final Name name;
    private Position position;
    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
