package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputerBaseBall {
    private static final int BASEBALL_MIN = 1;
    private static final int BASEBALL_MAX = 9;
    private static final String EMPTY = "";
    private BaseBall baseBalls;

    private ComputerBaseBall(final BaseBall baseBalls) {
        this.baseBalls = baseBalls;
    }

    public static ComputerBaseBall create() {
        List<Integer> computerBaseBall = IntStream.rangeClosed(BASEBALL_MIN, BASEBALL_MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(computerBaseBall);
        List<Integer> computerBaseBallSubList = new ArrayList<>(computerBaseBall.subList(0, 3));
        Collections.sort(computerBaseBallSubList);
        return new ComputerBaseBall(BaseBall.from(computerBaseBallSubList));
    }

    public static ComputerBaseBall from(final List<Integer> inputBaseBall) {
        return new ComputerBaseBall(BaseBall.from(inputBaseBall));
    }

    public static ComputerBaseBall from(final String inputBaseBall) {
        List<Integer> inputBaseBalls = Arrays.stream(inputBaseBall.split(EMPTY))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new ComputerBaseBall(BaseBall.from(inputBaseBalls));
    }

    public int extractBaseBall(final int index) {
        return this.baseBalls.extractBaseBall(index);
    }

    public int ballTotalCount() {
        return this.baseBalls.ballSize();
    }

    public boolean containsBall(final Ball ball) {
        return this.baseBalls.containsBall(ball);
    }

    public boolean matchStrike(final Ball userBall, final int index) {
        return this.baseBalls.extractBaseBall(index) == userBall.value();
    }
}
