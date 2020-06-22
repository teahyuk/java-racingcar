package com.nextstep.teahyuk.racing.result;

import com.nextstep.teahyuk.racing.vo.Racer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Game Result with all of rounds
 *
 * <p>It has every round status.
 * you can get final winner</p>
 *
 * @author teahyuk
 * @since 1.0
 */
public class GameResult {
    private final List<RoundResult> roundResults;

    public GameResult(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public GameResult(RoundResult... roundResults) {
        this(Arrays.asList(roundResults));
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public Collection<Racer> getWinners() {
        return roundResults.get(roundResults.size() - 1).getMaxDistanceRacers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(roundResults, that.roundResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundResults);
    }
}
