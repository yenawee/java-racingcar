import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.Car;
import domain.Winner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class WinnerTest {
    private static Car car1;
    private static Car car2;
    private static Car car3;
    private static Winner winner;

    @BeforeAll
    static void setup() {
        car1 = new Car("jerry");
        car2 = new Car("jena");
        car3 = new Car("poby");
        List<Car> cars = new ArrayList<>();

        winner = new Winner();
        while (car1.getDistance() != 5) car1.move();
        while (car2.getDistance() != 4) car2.move();
        while (car3.getDistance() != 5) car3.move();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        winner.makeWinnerList(cars);
    }

    @Test
    @DisplayName("winner 목록이 옳게 생성되었는지 확인하는 테스트")
    void winnerlist() {
        assertThat(winner.getWinnerNames().toArray())
                .containsExactly(car1.getName(),car3.getName());
    }

    @Test
    @DisplayName("winner 목록 출력이 제대로 되는지 확인하는 테스트")
    void toString_test() {
        assertThat(winner.toString()).contains(car3.getName());
    }
}
