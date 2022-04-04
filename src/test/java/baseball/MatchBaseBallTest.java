package baseball;

import baseball.domain.BaseBall;
import baseball.domain.MatchBaseBall;
import baseball.domain.MatchResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MatchBaseBallTest {
    @Test
    void 쓰리스트라이크() {
        MatchBaseBall matchBaseBall = MatchBaseBall.from("123");

        MatchResult matchResult = matchBaseBall.matchOf(BaseBall.from("123"));

        assertAll(
                () -> assertThat(matchResult.strikeCount()).isEqualTo(3),
                () -> assertThat(matchResult.ballCount()).isZero()
        );
    }

    @Test
    void 원스트라이크투볼() {
        MatchBaseBall matchBaseBall = MatchBaseBall.from("123");

        MatchResult matchResult = matchBaseBall.matchOf(BaseBall.from("132"));

        assertAll(
                () -> assertThat(matchResult.strikeCount()).isEqualTo(1),
                () -> assertThat(matchResult.ballCount()).isEqualTo(2)
        );
    }

    @Test
    void 쓰리볼() {
        MatchBaseBall matchBaseBall = MatchBaseBall.from("123");

        MatchResult matchResult = matchBaseBall.matchOf(BaseBall.from("312"));

        assertAll(
                () -> assertThat(matchResult.strikeCount()).isZero(),
                () -> assertThat(matchResult.ballCount()).isEqualTo(3)
        );
    }

    @Test
    void 낫싱() {
        MatchBaseBall matchBaseBall = MatchBaseBall.from("123");


        MatchResult matchResult = matchBaseBall.matchOf(BaseBall.from("789"));

        assertAll(
                () -> assertThat(matchResult.strikeCount()).isZero(),
                () -> assertThat(matchResult.ballCount()).isZero()
        );
    }
}
