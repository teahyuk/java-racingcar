package com.nextstep.teahyuk.racing;

import com.nextstep.teahyuk.racing.result.GameResult;
import com.nextstep.teahyuk.racing.result.RoundResult;
import com.nextstep.teahyuk.racing.vo.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Racing game business class
 *
 * <p>It is first collection with players</p>
 *
 * @author teahyuk
 * @since 1.0
 */
public class GameManager {
    private static final String PLAYERS_MUST_NOT_EMPTY = "GameManager initialize error. players must not empty";
    private static final String ROUND_COUNT_MUST_POSITIVE = "play error. roundCount at least 1, roundCount=%d";

    private final List<Player> players;

    public GameManager(List<Player> players) {
        checkPlayersEmpty(players);
        this.players = new ArrayList<>(players);
    }

    private void checkPlayersEmpty(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException(PLAYERS_MUST_NOT_EMPTY);
        }
    }

    GameManager(Player... players) {
        this(Arrays.asList(players));
    }

    public GameResult play(int roundCount) {
        checkRoundCount(roundCount);
        List<RoundResult> roundResults = new ArrayList<>();
        roundResults.add(getFirstRound());
        for (int i = 0; i < roundCount; i++) {
            roundResults.add(getNextRoundStatus(roundResults.get(i)));
        }
        return new GameResult(roundResults);
    }

    private void checkRoundCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException(String.format(ROUND_COUNT_MUST_POSITIVE, roundCount));
        }
    }

    private RoundResult getFirstRound() {
        return new RoundResult(players
                .stream()
                .collect(Collectors.toMap(Player::getRacer, Player::nextRound)));
    }

    private RoundResult getNextRoundStatus(RoundResult roundResult) {
        return new RoundResult(players
                .stream()
                .collect(Collectors.toMap(Player::getRacer, player -> player.nextRound(roundResult.distance(player.getRacer())))));
    }
}
