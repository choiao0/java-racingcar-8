package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        return Console.readLine();
    }

    public int getAttempts() {
        String attempts = Console.readLine();
        validateAttempts(attempts);
        return Integer.parseInt(attempts);
    }

    private void validateAttempts(String attempts) {
        if (attempts.trim().isEmpty() || !attempts.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}
