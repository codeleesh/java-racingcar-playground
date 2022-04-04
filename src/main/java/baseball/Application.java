package baseball;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.ResultView;

public class Application {

    public static void main(String[] args) {
        gameStart();
    }

    private static void gameStart() {

        ComputerBaseBall computerBaseBall = ComputerBaseBall.create();
        MatchBaseBall matchBaseBall = MatchBaseBall.from(computerBaseBall);
        MatchResult matchResult = MatchResult.empty();
        while (!matchResult.isThreeStrike()) {
            BaseBall userBaseBall = BaseBall.from(InputView.inputNumberPrint());
            matchResult = matchBaseBall.matchOf(userBaseBall);
            ResultView.resultPrint(matchResult);
        }
        String menuNumber = InputView.inputMenuNumberPrint();
        if (menuNumber.equals(Menu.NEW_START.value())) {
            gameStart();
        }
        if (menuNumber.equals(Menu.GAME_END.value())) {
            System.exit(0);
        }
    }
}
