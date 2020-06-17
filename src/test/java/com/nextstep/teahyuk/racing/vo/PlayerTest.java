package com.nextstep.teahyuk.racing.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PlayerTest {

    public static Player player1 = new Player("racer1", 100);
    public static Player player2 = new Player("racer2", 100);
    public static Player stopPlayer = new Player("stopper", 0);

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