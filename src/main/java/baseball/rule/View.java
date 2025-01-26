package baseball.rule;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static String readUserNumbers() {
        System.out.print("숫자 3개 입력하세요: ");

        return Console.readLine();
    }

    public static void PrintGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void PrintGameEnd(){
        System.out.println("게임을 종료합니다.");
    }
}
