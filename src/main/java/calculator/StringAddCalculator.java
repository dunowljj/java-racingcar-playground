package calculator;

import calculator.exception.ErrorCode;
import calculator.exception.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_CALC_REGEX = ":|,";
    public static final String CUSTOM_CALC_REGEX = "//(.)\\n(.*)";

    public int splitAndSum(String input){
        String[] tokens = getNums(input);
        return getSumOfNumsOrThrow(tokens);
    }

    private String[] getNums(String input) {
        String[] tokens = null;
        if (isDefaultCalc(input)) {
            tokens = getNumsByDefault(input);
        }
        if (isCustomCalc(input)) {
            tokens = getNumsByCustom(input);
        }
        return tokens;
    }
    private boolean isDefaultCalc(String input) {
        return getType(input) == CalcType.DEFAULT;
    }
    private boolean isCustomCalc(String input) {
        return getType(input) == CalcType.CUSTOM;
    }
    public CalcType getType(String input) {
        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);
        if(matcher.matches()){
            return CalcType.CUSTOM;
        }
        return CalcType.DEFAULT;
    }

    private String[] getNumsByDefault(String input) {
        return getNumsByDefaultOrThrow(input);
    }
    private String[] getNumsByDefaultOrThrow(String input) {
        String[] validResult;
        validResult = validPositive(input.split(DEFAULT_CALC_REGEX));
        return validResult;
    }


    private String[] getNumsByCustom(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_CALC_REGEX).matcher(input);
        String[] tokens = null;

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);
        }
        return validPositive(tokens);
    }
    private String[] validPositive(String[] input){
        for (String str : input) {
            throwIfNegativeNum(str);
        }
        return input;
    }
    private void throwIfNegativeNum(String str) {
        if (str.charAt(0) == '-'){
            throw new InvalidInputException(ErrorCode.NEGATIVE_NUMBER_INPUT);
        }
    }

    private int getSumOfNumsOrThrow(String[] tokens) throws InvalidInputException {
        int sum;
        try {
            sum = getSumOfNums(tokens);
        } catch (NumberFormatException e){
            throw new InvalidInputException(ErrorCode.INVALID_INPUT);
        }
        return sum;
    }
    private int getSumOfNums(String[] tokens) throws NumberFormatException{
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    public boolean isSymbol(String input) {
        Matcher matcher = Pattern.compile("[\\W]").matcher(getDelimiter(input));
        return matcher.matches();
    }
    private String getDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);
        String customDelimiter = "";
        if(matcher.find()){
            customDelimiter = matcher.group(1);
        }
        return customDelimiter;
    }

}
