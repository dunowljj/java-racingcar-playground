package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    public static final int FOWARD_NUM = 4;

    @Override
    public boolean movable() {
        int randomNum = new Random().nextInt(10);
        if (randomNum >= FOWARD_NUM) {
            return true;
        }
        return false;
    }
}
