package baseball.rule;

import java.util.List;

public abstract class CountNums {

        public static Result getResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
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
    }

