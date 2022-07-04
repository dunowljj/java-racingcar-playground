package racingcar.domain;

import racingcar.utils.StringUtils;

public class Car {
    private final Name name;
    private Position position;
    public Car(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
        this.name = new Name(name);
        this.position = new Position();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.move();
        }
    }
}
