package calculator.exception;

public enum ErrorCode {
    NEGATIVE_NUMBER_INPUT("음수는 계산할 수 없습니다."),
    INVALID_INPUT("입력이 잘못되었습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
