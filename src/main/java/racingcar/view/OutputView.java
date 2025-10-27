package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public void printCarNamesInputGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptsInputGuide() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRoundHeader() {
        System.out.println("\n실행 결과");
    }

    public void printRoundStatus(Cars cars) {
        StringBuilder roundStatus = new StringBuilder();
        for (Car car : cars.getCars()) {
            roundStatus.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        System.out.print(roundStatus);
    }

    public void printWinners(Cars cars) {
        String message = cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ", "\n최종 우승자 : ", ""));
        System.out.println(message);
    }
}
