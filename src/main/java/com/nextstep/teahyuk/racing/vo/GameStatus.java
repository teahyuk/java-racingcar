package com.nextstep.teahyuk.racing.vo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        Distance winnerDistance = getWinnerDistance(lastStatus);
        return lastStatus.getRacers()
                .stream()
                .filter(racer->lastStatus.distance(racer).equals(winnerDistance))
                .collect(Collectors.toList());
    }

    private Distance getWinnerDistance(RoundStatus lastStatus) {
        return lastStatus
                .getRacers()
                .stream()
                .map(lastStatus::distance)
                .max(Comparator.comparingInt(Distance::distance))
                .orElse(Distance.of());
    }
}
