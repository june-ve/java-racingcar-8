package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
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

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
