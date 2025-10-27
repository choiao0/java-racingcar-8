package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingGameServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final RacingGameService service = new RacingGameService();

    @Test
    @DisplayName("자동차 목록 정상적으로 생성 확인")
    void createCarsTest() {
        Cars cars = service.createCars("pobi,woni,jun");

        assertThat(cars.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("우승자 판단 테스트")
    void findWinnersTest() {
        Cars cars = service.createCars("pobi,woni,jun");
        cars.getCars().get(0).moveIfPossible(MOVING_FORWARD);
        cars.getCars().get(1).moveIfPossible(MOVING_FORWARD);
        cars.getCars().get(2).moveIfPossible(STOP);

        Cars winners = service.findWinners(cars);

        assertThat(winners.getCars())
                .extracting(Car::getName)
                .contains("pobi", "woni");
    }
}
