package racingcar.util;

public class TryCountParser {

    private TryCountParser() {}

    public static int parse(String input) {
        validateNotBlank(input);
        int tryCount = parseAsInt(input);
        validatePositive(tryCount);

        return tryCount;
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수 입력이 비어있을 수 없습니다.");
        }
    }

    // 문자열을 정수로 파싱한다. NumberFormatException을 처리한다.
    private static int parseAsInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validatePositive(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
