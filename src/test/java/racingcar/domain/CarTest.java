package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외 발생")
    void validateCarNameBlank() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상이면 전진")
    void checkMovingForward() {
        Car car = new Car("pobi");
        car.moveIfPossible(MOVING_FORWARD);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만이면 정지")
    void checkStop() {
        Car car = new Car("pobi");
        car.moveIfPossible(STOP);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
