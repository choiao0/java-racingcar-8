package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        String input = readInput();
        return removeBlank(input);
    }

    public int getAttempts() {
        String input = Console.readLine();
        input = removeBlank(input);
        validateAttempts(input);
        return convertToInt(input);
    }

    private String readInput() {
        return Console.readLine();
    }

    private String removeBlank(String input) {
        return input.replace(" ", "");
    }

    private void validateAttempts(String attempts) {
        if (attempts.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 공백일 수 없습니다.");
        }
        if (!isPosiveNumber(attempts)) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }

    private boolean isPosiveNumber(String number) {
        return number.matches("^[1-9][0-9]*$");
    }

    private int convertToInt(String attempts) {
        return Integer.parseInt(attempts);
    }
}
