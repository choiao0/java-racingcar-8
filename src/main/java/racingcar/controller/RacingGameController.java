package racingcar.controller;

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
        outputView.printAttemptsInputGuide();
        String attempts = inputView.getAttempts();
    }
}
