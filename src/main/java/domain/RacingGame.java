package domain;

import view.Output;

import java.util.List;

public class RacingGame {
    private final CarGenerator carGenerator;
    private final Winner winner;
    private List<Car> cars;
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        carGenerator = new CarGenerator();
        winner = new Winner();
        cars = carGenerator.generateCars(carNames);
        this.tryCount = tryCount;
    }

    public void start() {
        Output.printMessage("실행 결과");
        while (isGameContinue()) {
            cars.forEach(car -> car.move());
            Output.printEachCarDistance(cars);
        }
        winner.makeWinnerNames(cars);
    }

    public void printResult() {
        Output.printWinner(winner);
    }

    private boolean isGameContinue() {
        return this.tryCount-- > 0;
    }
}
