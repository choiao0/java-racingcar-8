package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printCarNamesInputGuide();
        String carNames = inputView.getCarNames();
        Cars cars = new Cars(createCars(carNames));

        outputView.printAttemptsInputGuide();
        int totalRounds = inputView.getAttempts();

        for (int round = 0; round < totalRounds; round++) {
            playRound(cars);
        }

        Cars winners = cars.findWinners();
        outputView.printWinners(winners);
    }

    private List<Car> createCars(String names) {
        return Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();
    }

    private void playRound(Cars cars) {
        outputView.printRoundHeader();
        for (Car car : cars.getCars()) {
            int randomNumber = pickRandomNumber();
            car.moveIfPossible(randomNumber);
            outputView.printRoundStatus(car);
        }
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
