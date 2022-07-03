package racingcar.domain;

public class Position {
    int position;

    public Position() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
