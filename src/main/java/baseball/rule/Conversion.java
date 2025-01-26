package baseball.rule;

import java.util.ArrayList;
import java.util.List;

public class Conversion {

    public static List<Integer> convertToIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }
}
