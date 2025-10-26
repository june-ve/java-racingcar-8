package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 정상_입력() {
        assertThatCode(() -> new Car("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    void 여섯_자_이상_입력_시_예외() {
        assertThatThrownBy(() -> new Car("javaji"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_예외() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null_예외() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_예외() {
        assertThatThrownBy(() -> new Car("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
