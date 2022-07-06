package racingcar.domain;

public class TryNum {
    private int tryNum;

    public TryNum(String input) {
        int tryNum = Integer.parseInt(input);
        if (tryNum <= 0) {
            throw new IllegalArgumentException("1 이상 정수를 입력해주세요.");
        }
        this.tryNum = tryNum;
    }

    public int getTryNum() {
        return tryNum;
    }
}