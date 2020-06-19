package com.nextstep.teahyuk.racing;

import com.nextstep.teahyuk.racing.vo.Distance;
import com.nextstep.teahyuk.racing.vo.RoundStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.nextstep.teahyuk.racing.vo.PlayerTest.*;
import static org.assertj.core.api.Assertions.*;

class GameManagerTest {

    @Test
    void constructor() {
        assertThatCode(() -> new GameManager(1, player1, player2))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void constructorCountError(int roundCount) {
        assertThatThrownBy(() -> new GameManager(roundCount, player1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructorPlayerError(){
        assertThatThrownBy(() -> new GameManager(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void play() {
        int roundCount = 4;
        GameManager gameManager = new GameManager(roundCount, Arrays.asList(player1, player2));
        RoundStatus[] expectRoundStatuses = IntStream.range(0, roundCount+1)
                .mapToObj(this::createExpectRoundStatus)
                .toArray(RoundStatus[]::new);

        assertThat(gameManager.play())
                .hasSize(roundCount+1)
                .containsExactly(expectRoundStatuses);
    }

    private RoundStatus createExpectRoundStatus(int distance) {
        return new RoundStatus(Stream.of(player1.getRacer(), player2.getRacer())
                .collect(Collectors.toMap(Function.identity(), racer -> Distance.of(distance))));
    }

    @Test
    void getWinners() {
        GameManager gameManager = new GameManager(1,Arrays.asList(player1, player2, stopPlayer));

        List<RoundStatus> roundStatuses = gameManager.play();
        RoundStatus lastState = roundStatuses.get(roundStatuses.size() - 1);
        assertThat(gameManager.getWinners(lastState))
                .hasSize(2)
                .containsExactlyInAnyOrder(player1.getRacer(), player2.getRacer());
    }
}
