package com.nextstep.teahyuk.racing;

import com.nextstep.teahyuk.racing.ui.Input;
import com.nextstep.teahyuk.racing.ui.Output;
import com.nextstep.teahyuk.racing.vo.GameStatus;
import com.nextstep.teahyuk.racing.vo.Player;
import com.nextstep.teahyuk.racing.vo.RoundStatus;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        List<Player> playerList = input.getRacers()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        int count = input.getRoundCount();

        GameManager gameManager = new GameManager(count, playerList);

        GameStatus gameStatus = gameManager.play();
        output.printRound(gameStatus.getRoundStatuses());
        output.printWinner(gameStatus.getWinners());
    }
}
