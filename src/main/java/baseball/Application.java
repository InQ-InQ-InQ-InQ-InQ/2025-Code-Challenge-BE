package baseball;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.text.ElementIterator;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);

    static int[] answer = new int[3];
    static Random rd = new Random();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            //정답 배열 생성
            for (int i = 0; i < 3; i++) {
                answer[i] = rd.nextInt(9) + 1; //1~9
                //중복 검증
                for (int j = 0; j < i; j++) {
                    if (answer[i] == answer[j]) {
                        answer[j] = rd.nextInt(9) + 1;
                    }
                }
            }
            for (int i : answer) {
                System.out.print(i);
            }
            System.out.println();
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
            int strike = 0;
            int ball = 0;

            System.out.print("\n숫자를 입력해주세요: ");
            String userInput = Console.readLine();
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("숫자 3자리를 입력해야 합니다.");
            }


            String array[] = userInput.split("");
            int[] userInputArray = new int[3];

            for (int i = 0; i < 3; i++) {
                userInputArray[i] = Integer.parseInt(array[i]);
            }

            //입력받은 숫자 검증
            for (int i = 0; i < 3; i++) { //정답
                for (int j = 0; j < 3; j++) { //유저
                    if (userInputArray[j] == answer[i]) {
                        if (j == i) {
                            strike++; //숫자, 자리 같으면 스트라이크
                        }
                        else ball++;
                    }
                }
            }


            if (ball != 0) System.out.print(ball + "볼 ");
            if (strike != 0) System.out.print(strike + "스트라이크");
            if (ball == 0 && strike == 0) System.out.print("낫싱");

            //결과
            if (Arrays.equals(answer, userInputArray)) {
                System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            else continue;
        }
    }
}