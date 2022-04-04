package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchBaseBall {
    private static final String EMPTY = "";

    private final ComputerBaseBall computerBaseBall;

    private MatchBaseBall(final ComputerBaseBall computerBaseBall) {
        this.computerBaseBall = computerBaseBall;
    }

    public static MatchBaseBall from(final String computerBaseBall) {
        List<Integer> computerBaseBalls = Arrays.stream(computerBaseBall.split(EMPTY))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new MatchBaseBall(ComputerBaseBall.from(computerBaseBalls));
    }

    public static MatchBaseBall from(final ComputerBaseBall computerBaseBall) {
        return new MatchBaseBall(computerBaseBall);
    }

    public MatchResult matchOf(final BaseBall userBaseBall) {
        int strike = 0;
        int ball = 0;
        for (int idx = 0; idx < userBaseBall.ballSize(); idx++) {
            if (this.computerBaseBall.containsBall(userBaseBall.valueBalls().get(idx))) {
                if (this.computerBaseBall.matchStrike(userBaseBall.valueBalls().get(idx), idx)) {
                    strike++;
                    continue;
                }
                ball++;
            }
        }
        return MatchResult.of(strike, ball);
    }
}
