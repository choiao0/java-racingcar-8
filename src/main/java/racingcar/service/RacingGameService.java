package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingGameService {
    public Cars createCars(String carNames) {
        return new Cars(
                Arrays.stream(carNames.split(","))
                        .map(Car::new)
                        .toList()
        );
    }

    public void playRound(Cars cars) {
        for (Car car : cars.getCars()) {
            int randomNumber = pickRandomNumber();
            car.moveIfPossible(randomNumber);
        }
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Cars findWinners(Cars cars) {
        return cars.findWinners();
    }
}
