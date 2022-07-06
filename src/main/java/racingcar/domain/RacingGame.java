package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RacingGame {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public int play() {
        try {
            tryToPlay();
        } catch (Exception e) {
            System.out.println(e.getMessage()+" 처음부터 다시 입력해주세요.\n---");
            return play();
        }
        return 1;
    }

    public void tryToPlay() throws IOException, InterruptedException {

        InputView.printRequireNames();
        String names = reader.readLine();
        Cars cars = new Cars(names);

        InputView.printRequireRepeat();
        String num = reader.readLine();
        TryNum tryNum = new TryNum(num);

        ResultView.printTitle();
        for (int i = 0; i < tryNum.getTryNum(); i++) {
            cars.move(new RandomMovingStrategy());
            ResultView.printRace(cars);
            Thread.sleep(1000);
        }
        ResultView.printWinner(cars.getWinners());
    }
}
