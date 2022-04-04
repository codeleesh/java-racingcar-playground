package view;

import baseball.domain.MatchResult;
import baseball.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @DisplayName("3스트라이크 출력")
    @Test
    void 쓰리스트라이크_출력() {
        MatchResult matchResult = MatchResult.of(3, 0);
        ResultView.resultPrint(matchResult);
    }

    @DisplayName("1볼2스트라이크 출력")
    @Test
    void 원볼_투스트라이크_출력() {
        MatchResult matchResult = MatchResult.of(2, 1);
        ResultView.resultPrint(matchResult);
    }

    @DisplayName("3볼 출력")
    @Test
    void 쓰리볼_출력() {
        MatchResult matchResult = MatchResult.of(0, 3);
        ResultView.resultPrint(matchResult);
    }

    @DisplayName("낫싱 출력")
    @Test
    void 낫싱_출력() {
        MatchResult matchResult = MatchResult.of(0, 0);
        ResultView.resultPrint(matchResult);
    }
}
