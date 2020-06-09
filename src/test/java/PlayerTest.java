import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PlayerTest {

    @Test
    void constructor() {
        assertThatCode(() -> new Player("racer", 40))
                .doesNotThrowAnyException();

        assertThatCode(() -> new Player("racer"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "100,0,1",
            "0,0,0",
            "100,1,2"
    })
    void move(int canGoPercent, int currentDistance, int expectedFirstDistance) {
        Player player = new Player("racer", canGoPercent);

        assertThat(player.nextRound(currentDistance))
                .isEqualTo(expectedFirstDistance);
    }
}