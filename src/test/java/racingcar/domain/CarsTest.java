package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("중복되지 않은 자동차 이름이면 정상 생성")
    void validCarNames() {
        List<Car> carList = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        Cars cars = new Cars(carList);

        assertThat(cars.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외 발생")
    void validateDuplicateCarName() {
        List<Car> carList = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("pobi")
        );

        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("단독 우승자 판단")
    void findSingleWinner() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.moveIfPossible(MOVING_FORWARD);
        car2.moveIfPossible(STOP);

        Cars cars = new Cars(List.of(car1, car2));
        Cars winners = cars.findWinners();

        assertThat(winners.getCars().size()).isEqualTo(1);
        assertThat(winners.getCars())
                .extracting(Car::getName)
                .contains("pobi");
    }

    @Test
    @DisplayName("공동 우승자 판단")
    void findMultipleWinners() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.moveIfPossible(MOVING_FORWARD);
        car2.moveIfPossible(MOVING_FORWARD);

        Cars cars = new Cars(List.of(car1, car2));
        Cars winners = cars.findWinners();

        assertThat(winners.getCars().size()).isEqualTo(2);
        assertThat(winners.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "woni");
    }
}
