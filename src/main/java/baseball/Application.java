package baseball;

import baseball.rule.CountNums;
import baseball.rule.CreateRandomNum;
import baseball.rule.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean playAgain = true;

        View.PrintGameStart();

        while (playAgain) {
            //난수 생성
            List<Integer> computerNumbers = CreateRandomNum.ComputerRandomNumbers();
            boolean gameWon = true;

            //사용자 입력 및 게임 실행
            while (gameWon) {
                String userInput = View.readUserNumbers();

                InputValidator.validate(userInput);

                List<Integer> userNumbers = Conversion.convertToIntegerList(userInput); // 입력값 -> 정수
                Result result = CountNums.getResult(computerNumbers, userNumbers); // strike, ball 계산

                if (result.isAllStrike()) { // result.isAllStrike()
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameWon = false;
                } else if (!result.isNothing()) {
                    System.out.printf("%d볼 %d스트라이크\n", result.balls, result.strikes);
                } else {
                    System.out.println("낫싱");
                }
            }

            // 게임 재시작 여부
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine(); // 1 또는 2 입력

            if (restart.equals("1")) {
                playAgain = true;
            } else if (restart.equals("2")) {
                playAgain = false;
            } else {
                System.out.println("잘못된 값을 입력하셨습니다. 게임을 종료합니다.");
                throw new IllegalArgumentException();
            }
        }

        View.PrintGameEnd();
        Console.close();
    }

}
