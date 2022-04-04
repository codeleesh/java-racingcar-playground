package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BaseBall {

    public static final String EMPTY = "";
    private List<Ball> balls;

    private BaseBall(final List<Integer> inputBaseBalls) {
        this.balls =  inputBaseBalls.stream()
                .map(Ball::from)
                .collect(Collectors.toList());
    }

    public static BaseBall from(final List<Integer> inputBaseBalls) {
        return new BaseBall(inputBaseBalls);
    }

    public static BaseBall from(final String inputBaseBall) {
        List<Integer> inputBaseBalls = Arrays.stream(inputBaseBall.split(EMPTY))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new BaseBall(inputBaseBalls);
    }

    public int extractBaseBall(int index) {
        return this.balls.get(index)
                .value();
    }

    public int ballSize() {
        return this.balls.size();
    }

    public List<Ball> valueBalls() {
        return this.balls;
    }

    public boolean containsBall(final Ball ball) {
        return this.balls.contains(ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBall baseBall = (BaseBall) o;
        return Objects.equals(balls, baseBall.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
