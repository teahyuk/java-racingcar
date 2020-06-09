import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarTest {

    @Test
    void canMoveRate() {
        assertThatCode(Car::new)
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"100,true", "0,false"})
    void moveTest(int canMovePercent, boolean isMoved) {
        Car car = new Car(canMovePercent);
        assertThat(car.move())
                .isEqualTo(isMoved);
    }

}
