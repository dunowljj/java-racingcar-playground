package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Scanner;

public class Racingcar {
    Scanner scanner = new Scanner(System.in);
    public void play() throws InterruptedException {
        InputView inputView = new InputView();

        inputView.askCarName();
        String input = scanner.nextLine();

        inputView.askTimes();
        int times = Integer.parseInt(scanner.nextLine());

        Cars cars = new Cars(input);
        race(times, cars);
    }

    private void race(int times, Cars cars) throws InterruptedException {
        ResultView resultView = new ResultView();

        resultView.showStartMessage();
        for (int i = 0; i < times; i++) {
            cars.go();
            resultView.showRace(cars);
            Thread.sleep(1000);
            System.out.println();
        }
        resultView.showResult(cars);
    }

}
