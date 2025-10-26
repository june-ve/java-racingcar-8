package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class RacingGame {

    private static final int MOVE_CONDITION = 4;

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void moveOnce() {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= MOVE_CONDITION;
    }
}
