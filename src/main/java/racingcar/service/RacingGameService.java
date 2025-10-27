package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingGameService {
    public Cars createCars(String carNames) {
        String[] splitName = splitName(carNames);
        return new Cars(Arrays.stream(splitName)
                .map(Car::new)
                .toList()
        );
    }

    private String[] splitName(String carNames) {
        return carNames.split(",");
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
