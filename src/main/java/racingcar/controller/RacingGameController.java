package racingcar.controller;

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
        int attempts = inputView.getAttempts();
    }

    private List<Car> createCars(String names) {
        return Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();
    }
}
