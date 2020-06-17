package com.nextstep.teahyuk.racing;

import com.nextstep.teahyuk.racing.vo.Distance;
import com.nextstep.teahyuk.racing.vo.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private final List<Player> players;

    public GameManager(Player... players) {
        this.players = Arrays.asList(players);
    }

    public RoundStatus firstRound() {
        return new RoundStatus(players.stream()
                .collect(Collectors.toMap(Player::getRacer, player -> Distance.of())));
    }

    public RoundStatus nextRound(RoundStatus currentStatus) {
        return new RoundStatus(players.stream()
                .collect(Collectors.toMap(Player::getRacer, player ->
                        player.nextRound(currentStatus.distance(player.getRacer())))));
    }
}
