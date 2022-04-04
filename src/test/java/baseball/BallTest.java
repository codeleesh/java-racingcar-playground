package baseball;

import baseball.domain.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @DisplayName("BaseBall 1~9 사이 값 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9})
    void 번호생성(int number) {
        final Ball ball = Ball.from(number);
        assertThat(ball.value()).isEqualTo(number);
    }

    @DisplayName("BaseBall 1~9까지 외에 값은 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10, 11})
    void 번호생성_예외(int number) {
        assertThatThrownBy(() -> Ball.from(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("야구 숫자는 1부터 9까지의 숫자만 해당됩니다.");
    }
}
