package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {}

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generatePositionBar(car.getPosition()));
        }
        System.out.println();
    }

    private static String generatePositionBar(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
