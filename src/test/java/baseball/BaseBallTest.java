package baseball;

import baseball.domain.BaseBall;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseBallTest {

    @DisplayName("사용자 BaseBall List 입력으로 생성")
    @Test
    void 사용자_베이스볼_리스트입력_생성() {
        final BaseBall baseBall = BaseBall.from(Lists.newArrayList(1, 9, 8));

        assertThat(baseBall.ballSize()).isEqualTo(3);
    }

    @DisplayName("사용자 BaseBall String 문자열 입력으로 생성")
    @Test
    void 사용자_베이스볼_스트링입력_생성() {
        final BaseBall baseBall = BaseBall.from("123");

        assertAll(
                () -> assertThat(baseBall.extractBaseBall(0)).isEqualTo(1),
                () -> assertThat(baseBall.extractBaseBall(1)).isEqualTo(2),
                () -> assertThat(baseBall.extractBaseBall(2)).isEqualTo(3)
        );
    }
}
