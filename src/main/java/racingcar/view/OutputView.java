package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    public void printCarNamesInputGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptsInputGuide() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printCarPosition(Car car) {
        String carPosition = car.getName() + " : " + "-".repeat(car.getPosition());
        System.out.println(carPosition);
    }
}
