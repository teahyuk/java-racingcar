package com.nextstep.teahyuk.racing.vo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GameStatus {
    private final List<RoundStatus> roundStatuses;

    public GameStatus(RoundStatus... roundStatuses) {
        this.roundStatuses = Arrays.asList(roundStatuses);
    }

    public List<RoundStatus> getRoundStatuses() {
        return roundStatuses;
    }

    public Collection<Racer> getWinners() {
        return getWinners(roundStatuses.get(roundStatuses.size() - 1));
    }

    public Collection<Racer> getWinners(RoundStatus lastStatus) {
        return lastStatus.getMaxDistanceRacers();
    }

}
