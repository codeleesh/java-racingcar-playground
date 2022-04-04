package baseball.view;

import baseball.domain.MatchResult;

public class ResultView {

    public static final int ZERO = 0;

    public static void resultPrint(final MatchResult matchResult) {
        final int strike = matchResult.strikeCount();
        final int ball = matchResult.ballCount();

        if (matchResult.isThreeStrike()) {
            System.out.printf("%d스트라이크%n", strike);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return ;
        }
        if (strike > ZERO && ball > ZERO) {
            System.out.printf("%d볼 %d스트라이크%n", ball, strike);
            return ;
        }
        if (strike > ZERO && ball == ZERO) {
            System.out.printf("%d스트라이크%n", strike);
            return ;
        }
        if (strike == ZERO && ball > ZERO) {
            System.out.printf("%d볼%n", ball);
            return ;
        }
        System.out.printf("낫싱%n");
    }

    private ResultView() {}
}
