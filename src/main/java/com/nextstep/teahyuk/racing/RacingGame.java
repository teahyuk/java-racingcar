package com.nextstep.teahyuk.racing;

import com.nextstep.teahyuk.racing.ui.Input;
import com.nextstep.teahyuk.racing.ui.Output;
import com.nextstep.teahyuk.racing.result.GameResult;
import com.nextstep.teahyuk.racing.vo.Player;

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
        GameManager gameManager = new GameManager(playerList);

        GameResult gameResult = gameManager.play(input.getRoundCount());

        output.printRound(gameResult.getRoundResults());
        output.printWinner(gameResult.getWinners());
    }
}
