package racingcar.util;

import java.util.Arrays;
import java.util.List;

public final class CarNamesParser {

    private CarNamesParser() {}

    public static List<String> parse(String input) {
        validateInputNotNullOrEmpty(input);

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        validateCarCount(carNames);
        validateDuplicateCarNames(carNames);

        return carNames;
    }

    private static void validateInputNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 입력이 비어있을 수 없습니다.");
        }
    }

    private static void validateCarCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차는 최소 두 대 이상이어야 합니다.");
        }
    }

    private static void validateDuplicateCarNames(List<String> carNames) {
        long distinctCount = carNames.stream().distinct().count();
        if (distinctCount != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
