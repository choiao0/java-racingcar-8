package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        outputView.printCarNamesInputGuide();
        String carNames = inputView.getCarNames();
        Cars cars = racingGameService.createCars(carNames);

        outputView.printAttemptsInputGuide();
        int totalRounds = inputView.getAttempts();

        for (int round = 0; round < totalRounds; round++) {
            outputView.printRoundHeader();
            racingGameService.playRound(cars);
            outputView.printRoundStatus(cars);
        }

        Cars winners = racingGameService.findWinners(cars);
        outputView.printWinners(winners);
    }
}
