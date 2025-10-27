package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingController {

    public void run() {
        // 1. 자동차 이름 입력 및 파싱
        List<String> carNames = InputView.inputCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        // 2. 시도 횟수 입력 및 파싱
        int tryCount = InputView.inputTryCount();

        // 3. 게임 생성
        RacingGame game = new RacingGame(cars);

        // 4. 시도 횟수만큼 반복하며 이동 및 출력
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            game.moveOnce();
            ResultView.printRound(game.getCars());
        }

        // 5. 최종 우승자 출력
        ResultView.printWinners(game.getWinners());
    }
}
