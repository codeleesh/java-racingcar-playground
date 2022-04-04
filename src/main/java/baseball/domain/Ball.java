package baseball.domain;

import java.util.Objects;
import java.util.Random;

public class Ball {

    private static final Random random = new Random();

    private int baseBall;

    private Ball(final int baseBall) {
        validate(baseBall);
        this.baseBall = baseBall;
    }

    private void validate(final int baseBall) {
        if (baseBall <= 0 || baseBall >= 10) {
            throw new IllegalArgumentException("야구 숫자는 1부터 9까지의 숫자만 해당됩니다.");
        }
    }

    public static Ball create() {
        return new Ball(random.nextInt(10));
    }

    public static Ball from(final int baseBall) {
        return new Ball(baseBall);
    }

    public int value() {
        return this.baseBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return baseBall == ball.baseBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseBall);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "baseBall=" + baseBall +
                '}';
    }
}
