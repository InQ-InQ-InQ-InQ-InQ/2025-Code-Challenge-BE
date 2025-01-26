package baseball;

public class Result {
    public int strike;
    public int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }
}
