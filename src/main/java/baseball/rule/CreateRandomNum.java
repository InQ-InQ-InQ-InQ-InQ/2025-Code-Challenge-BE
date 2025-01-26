package baseball.rule;

import java.util.*;

public class CreateRandomNum {
    // 난수 생성
    public static List<Integer> ComputerRandomNumbers() {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            numbers.add(random.nextInt(9) + 1); // 1부터 9까지의 랜덤 3개 숫자
        }

        return new ArrayList<>(numbers);

    }
}
