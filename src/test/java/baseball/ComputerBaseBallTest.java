package baseball;

import baseball.domain.ComputerBaseBall;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ComputerBaseBallTest {

    @DisplayName("컴퓨터 BaseBall 자동 생성")
    @Test
    void 컴퓨터_베이스볼_자동생성() {
        final ComputerBaseBall computerBaseBall = ComputerBaseBall.create();

        assertThat(computerBaseBall.ballTotalCount()).isEqualTo(3);
    }

    @DisplayName("컴퓨터 BaseBall List 입력으로 생성")
    @Test
    void 컴퓨터_베이스볼_리스트입력_생성() {
        final ComputerBaseBall computerBaseBall = ComputerBaseBall.from(Lists.newArrayList(1,2,3));

        assertAll(
                () -> assertThat(computerBaseBall.extractBaseBall(0)).isEqualTo(1),
                () -> assertThat(computerBaseBall.extractBaseBall(1)).isEqualTo(2),
                () -> assertThat(computerBaseBall.extractBaseBall(2)).isEqualTo(3)
        );
    }

    @DisplayName("컴퓨터 BaseBall String 문자열 입력으로 생성")
    @Test
    void 컴퓨터_베이스볼_스트링입력_생성() {
        final ComputerBaseBall computerBaseBall = ComputerBaseBall.from("123");

        assertAll(
                () -> assertThat(computerBaseBall.extractBaseBall(0)).isEqualTo(1),
                () -> assertThat(computerBaseBall.extractBaseBall(1)).isEqualTo(2),
                () -> assertThat(computerBaseBall.extractBaseBall(2)).isEqualTo(3)
        );
    }
}
