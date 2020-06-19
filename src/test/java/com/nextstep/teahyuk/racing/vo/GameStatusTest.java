package com.nextstep.teahyuk.racing.vo;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class GameStatusTest {
    private final Racer racer1 = new Racer("racer1");
    private final Racer racer2 = new Racer("racer2");

    private final Map<Racer, Distance> racerMap = Stream.of(racer1, racer2)
            .collect(Collectors.toMap(Function.identity(), racer -> Distance.of()));

    @Test
    void getRoundStatuses() {
        RoundStatus first = new RoundStatus(racerMap);
        racerMap.replace(racer2, Distance.of(2));
        RoundStatus second = new RoundStatus(racerMap);

        GameStatus gameStatus = new GameStatus(first, second);

        assertThat(gameStatus.getRoundStatuses())
                .containsExactly(first, second);
    }

    @Test
    void getWinner() {
        RoundStatus first = new RoundStatus(racerMap);
        racerMap.replace(racer1, Distance.of(2));
        RoundStatus second = new RoundStatus(racerMap);

        GameStatus gameStatus = new GameStatus(first, second);

        assertThat(gameStatus.getWinners())
                .containsExactly(racer1);
    }

}
