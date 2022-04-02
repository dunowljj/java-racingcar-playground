package calculator.exception;

public class InvalidInputException extends RuntimeException{
    ErrorCode errorCode;
    String message;
    public InvalidInputException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMessage());
    }
    public InvalidInputException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
        message = customMessage;
    }
}
