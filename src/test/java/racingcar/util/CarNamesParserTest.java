package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarNamesParserTest {

    @Test
    void 정상_입력() {
        List<String> carNames = CarNamesParser.parse("pobi,woni,jun");
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 한_대_입력_시_예외() {
        assertThatThrownBy(() -> CarNamesParser.parse("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_예외() {
        assertThatThrownBy(() -> CarNamesParser.parse(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_이름_예외() {
        assertThatThrownBy(() -> CarNamesParser.parse("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
