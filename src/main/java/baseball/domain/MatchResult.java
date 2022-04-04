package baseball.domain;

public class MatchResult {
    public static final int THREE_STRIKE = 3;
    public static final int ZERO = 0;
    private int strike;
    private int ball;

    private MatchResult(final int strike, final int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static MatchResult empty() {
        return new MatchResult(ZERO, ZERO);
    }

    public static MatchResult of(final int strike, final int ball) {
        return new MatchResult(strike, ball);
    }

    public int strikeCount() {
        return this.strike;
    }

    public int ballCount() {
        return this.ball;
    }

    public boolean isThreeStrike() {
        return this.strike == THREE_STRIKE;
    }
}
