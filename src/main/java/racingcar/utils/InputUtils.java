package racingcar.utils;

public class InputUtils {

    public static boolean isBlank(String name) {
        if (name == null || name.trim().equals("")) {
            return true;
        }
        return false;
    }
}
