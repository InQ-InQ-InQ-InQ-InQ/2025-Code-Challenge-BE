package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (playAgain) {
            //난수 생성
            List<Integer> pc = Application.ComputerRandomNumbers();
            boolean gameWon = true;

            //사용자 입력 및 게임 실행
            while (gameWon) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = scanner.nextLine(); //숫자 입력

                // IllegalArgumentException
                if (!Application.ValidInput(userInput)) {
                    System.out.println("잘못된 값을 입력하셨습니다. 게임을 종료합니다.");
                    throw new IllegalArgumentException();
                }

                List<Integer> user = convertToIntegerList(userInput); // 입력값 -> 정수
                Result result = getResult(pc, user); // strike, ball 계산

                if (result.strikes == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameWon = false;
                } else if (result.strikes > 0 || result.balls > 0) {
                    System.out.printf("%d볼 %d스트라이크\n", result.balls, result.strikes);
                } else {
                    System.out.println("낫싱");
                }
            }

            // 게임 재시작 여부
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = scanner.nextLine(); // 1 또는 2 입력

            if (restart.equals("1")) {
                playAgain = true;
            } else if (restart.equals("2")) {
                playAgain = false;
            } else {
                System.out.println("잘못된 값을 입력하셨습니다. 게임을 종료합니다.");
                throw new IllegalArgumentException();
            }
        }

        System.out.println("게임을 종료합니다.");
        scanner.close();
    }

    private static List<Integer> ComputerRandomNumbers() {
        Random random = new Random();
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < 3) {
            numbers.add(random.nextInt(9) + 1); // 1부터 9까지의 랜덤 3개 숫자
        }

        return new ArrayList<>(numbers);
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

    // 문자열 입력값을 정수 리스트로 변환
    private static List<Integer> convertToIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    // 결과를 계산하기 (볼과 스트라이크)
    private static Result getResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        return new Result(strikes, balls);
    }

    // 결과 클래스
    private static class Result {
        int strikes;
        int balls;

        Result(int strikes, int balls) {
            this.strikes = strikes;
            this.balls = balls;
        }
    }
}




