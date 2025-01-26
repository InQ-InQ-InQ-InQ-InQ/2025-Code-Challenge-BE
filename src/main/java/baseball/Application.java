package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    static Scanner scanner = new Scanner(System.in);

    static int[] answer = new int[3];
    static Random rd = new Random();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            //게임 시작
            System.out.print("숫자 야구 게임을 시작합니다.");
            start_game();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int continue_answer = Integer.parseInt(Console.readLine());
            if (continue_answer == 1) continue;
            else if (continue_answer == 2) {
                break;
            }
        }
    }

    private static void start_game() {
        while (true) {
            //정답 배열 생성
            List<Integer> answerNumbers = make_answer();
            for (Integer i : answerNumbers) {
                System.out.print(i);
            }

            //볼, 스트라이크 판별
            while (true) {
                //숫자 입력받고 list에 저장
                List<Integer> userNumbers = getNumbers();
                Result result = verifyNumbers(answerNumbers, userNumbers);

                if (result.ball != 0) System.out.println(result.ball + "볼");
                if (result.strike == 1 || result.strike == 2) System.out.println(result.strike + "스트라이크");
                else if (result.strike == 0 && result.ball == 0) {
                    System.out.println("낫싱");
                }
                if (result.strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else continue;
            }


        }
    }

    private static List<Integer> make_answer() {
        List<Integer> answerNumbers = new ArrayList<>();
        while(answerNumbers.size() < 3) {
            int number = rd.nextInt(9) + 1; //1~9
            if (!answerNumbers.contains(number)) {
                answerNumbers.add(number);
            }
        }
        return answerNumbers;
    }

    private static Result verifyNumbers(List<Integer> answerNumbers, List<Integer> userNumbers) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            if (answerNumbers.contains(userNumbers.get(i))) {
                if (answerNumbers.get(i) == userNumbers.get(i)) {
                    strike++;
                }
                else ball++;
            }
        }
        return new Result(strike, ball);
    }

    private static List<Integer> getNumbers() {
        List<Integer> userInput = new ArrayList<>();

        System.out.print("\n숫자를 입력해주세요: ");
        String input = Console.readLine();

        for (int i = 0; i < input.length(); i++) {
            userInput.add(input.charAt(i) - '0');
        }

        return userInput;
    }
}