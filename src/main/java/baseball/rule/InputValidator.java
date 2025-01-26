package baseball.rule;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void validate(String userInput) {
        // IllegalArgumentException
        if (!ValidInput(userInput)) {
            System.out.println("잘못된 값을 입력하셨습니다. 게임을 종료합니다.");
            throw new IllegalArgumentException();
        }
    }

    // 사용자 입력값 유효성 (IllegalArgumentException)
    private static boolean ValidInput(String input) {
        if (input.length() != 3) return false;

        Set<Character> unique = new HashSet<>();
        // 중복된 숫자를 확인하기 위해 숫자를 저장할 공간 생성
        Set<Character> uniqueNumbers = new HashSet<>();
        // 입력값의 각 문자를 하나씩 확인
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i); // 입력값에서 한 글자 가져오기

            //숫자가 아닌 경우
            if (!Character.isDigit(ch) || ch == '0') {
                return false;
            }
            uniqueNumbers.add(ch);
        }
        return uniqueNumbers.size() == 3;
    }
}
