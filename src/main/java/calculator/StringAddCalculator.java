package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public boolean checkInput(String input) {
        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);
        if(matcher.find()){
            String customDelimeter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimeter);
        }
        return matcher.matches();
    }
}
