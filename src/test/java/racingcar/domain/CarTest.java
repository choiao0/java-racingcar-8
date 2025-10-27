package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    @DisplayName("유효한 이름으로 자동차 생성")
    void validCarName(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "longname"})
    @DisplayName("자동차 이름이 1~5자가 아니면 예외 발생")
    void validateCarNameLength(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외 발생")
    void validateCarNameBlank() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, 5자 이하여야 합니다.");
    }
}
