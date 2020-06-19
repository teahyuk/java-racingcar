package com.nextstep.teahyuk.racing;

import com.nextstep.teahyuk.racing.vo.Distance;
import com.nextstep.teahyuk.racing.vo.GameStatus;
import com.nextstep.teahyuk.racing.vo.Racer;
import com.nextstep.teahyuk.racing.vo.RoundStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    void constructorPlayerError() {
        assertThatThrownBy(() -> new GameManager(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void play() {
        int roundCount = 1;
        GameManager gameManager = new GameManager(roundCount, Arrays.asList(player1, player2, stopPlayer));
        RoundStatus firstRound = createExpectRoundStatus(0, 0, 0);
        RoundStatus secondRound = createExpectRoundStatus(1, 1, 0);
        GameStatus expectedGameStatus = new GameStatus(firstRound, secondRound);

        assertThat(gameManager.play())
                .isEqualTo(expectedGameStatus);
    }

    private RoundStatus createExpectRoundStatus(int racer1Distance, int racer2Distance, int racer3Distance) {
        Map<Racer, Distance> racerMap = new HashMap<>();
        racerMap.put(player1.getRacer(), Distance.of(racer1Distance));
        racerMap.put(player2.getRacer(), Distance.of(racer2Distance));
        racerMap.put(stopPlayer.getRacer(), Distance.of(racer3Distance));
        return new RoundStatus(racerMap);
    }
}
