package com.nextstep.teahyuk.racing;

import com.nextstep.teahyuk.racing.vo.GameStatus;
import com.nextstep.teahyuk.racing.vo.Player;
import com.nextstep.teahyuk.racing.vo.RoundStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Racing game business class
 *
 * <p>It handle racers, round count, play and return game result</p>
 *
 * @author teahyuk
 * @since 1.0
 */
public class GameManager {
    private static final String INVALID_FORMAT = "GameManager initialize error. roundCount must be positive and players must not empty, " +
            "roundCount=%d, players.size=%d";

    private final List<Player> players;
    private final int roundCount;

    public GameManager(int roundCount, List<Player> players) {
        checkValidation(roundCount, players);
        this.players = new ArrayList<>(players);
        this.roundCount = roundCount;
    }

    private void checkValidation(int roundCount, List<Player> players) {
        if (roundCount < 1 || players.size() == 0) {
            throw new IllegalArgumentException(String.format(INVALID_FORMAT, roundCount, players.size()));
        }
    }

    GameManager(int roundCount, Player... players) {
        this(roundCount, Arrays.asList(players));
    }

    public GameStatus play() {
        List<RoundStatus> roundStatuses = new ArrayList<>();
        roundStatuses.add(getFirstRound());
        for (int i = 0; i < roundCount; i++) {
            roundStatuses.add(getNextRoundStatus(roundStatuses.get(i)));
        }
        return new GameStatus(roundStatuses);
    }

    private RoundStatus getFirstRound() {
        return new RoundStatus(players
                .stream()
                .collect(Collectors.toMap(Player::getRacer, Player::nextRound)));
    }

    private RoundStatus getNextRoundStatus(RoundStatus roundStatus) {
        return new RoundStatus(players
                .stream()
                .collect(Collectors.toMap(Player::getRacer, player -> player.nextRound(roundStatus.distance(player.getRacer())))));
    }
}
