package baseball.rule;

public class Result {
    public int strikes;
    public int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isAllStrike() {
        return strikes == 3;
    }

    public boolean isNothing() {
        return strikes == 0 && balls == 0;
    }
}
