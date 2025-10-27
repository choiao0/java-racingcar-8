package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        String input = readInput();
        return trimInput(input);
    }

    public int getAttempts() {
        String input = Console.readLine();
        String trimmedInput = trimInput(input);
        validateAttempts(trimmedInput);
        return convertToInt(trimmedInput);
    }

    private String readInput() {
        return Console.readLine();
    }

    private String trimInput(String input) {
        return input.trim();
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
