package com.nextstep.teahyuk.racing.vo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class GameStatus {
    private final List<RoundStatus> roundStatuses;

    public GameStatus(List<RoundStatus> roundStatuses) {
        this.roundStatuses = roundStatuses;
    }

    public GameStatus(RoundStatus... roundStatuses) {
        this(Arrays.asList(roundStatuses));
    }

    public List<RoundStatus> getRoundStatuses() {
        return roundStatuses;
    }

    public Collection<Racer> getWinners() {
        return roundStatuses.get(roundStatuses.size() - 1).getMaxDistanceRacers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameStatus that = (GameStatus) o;
        return Objects.equals(roundStatuses, that.roundStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundStatuses);
    }
}
