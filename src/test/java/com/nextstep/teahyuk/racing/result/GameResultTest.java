package com.nextstep.teahyuk.racing.result;

import com.nextstep.teahyuk.racing.vo.Distance;
import com.nextstep.teahyuk.racing.vo.Racer;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class GameResultTest {
    private final Racer racer1 = new Racer("racer1");
    private final Racer racer2 = new Racer("racer2");

    private final Map<Racer, Distance> racerMap = Stream.of(racer1, racer2)
            .collect(Collectors.toMap(Function.identity(), racer -> Distance.of()));

    @Test
    void getRoundStatuses() {
        RoundResult first = new RoundResult(racerMap);
        racerMap.replace(racer2, Distance.of(2));
        RoundResult second = new RoundResult(racerMap);

        GameResult gameResult = new GameResult(first, second);

        assertThat(gameResult.getRoundResults())
                .containsExactly(first, second);
    }

    @Test
    void getWinner() {
        RoundResult first = new RoundResult(racerMap);
        racerMap.replace(racer1, Distance.of(2));
        RoundResult second = new RoundResult(racerMap);

        GameResult gameResult = new GameResult(first, second);

        assertThat(gameResult.getWinners())
                .containsExactly(racer1);
    }

}
