import com.nextstep.teahyuk.racing.Distance;
import com.nextstep.teahyuk.racing.Player;
import com.nextstep.teahyuk.racing.Racer;
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
    void nextRound(int canGoPercent, int currentDistance, int expectedFirstDistance) {
        Player player = new Player("racer", canGoPercent);

        assertThat(player.nextRound(Distance.of(currentDistance)))
                .isEqualTo(Distance.of(expectedFirstDistance));
    }

    @Test
    void getRacer() {
        Player player = new Player("racer");
        assertThat(player.getRacer().name())
                .isEqualTo(new Racer("racer").name());
    }
}