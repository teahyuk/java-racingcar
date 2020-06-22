package com.nextstep.teahyuk.racing.vo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Round result
 *
 * <p>It means each player's distance map single round</p>
 *
 * @author teahyuk
 * @since 1.0
 */
public class RoundStatus {
    private final Map<Racer, Distance> racerDistanceMap;

    public RoundStatus(Map<Racer, Distance> racerDistanceHashMap) {
        this.racerDistanceMap = new HashMap<>(racerDistanceHashMap);
    }

    public Collection<Racer> getRacers() {
        return racerDistanceMap.keySet();
    }

    public Distance distance(Racer racer) {
        return racerDistanceMap.get(racer);
    }

    public Collection<Racer> getMaxDistanceRacers() {
        return getSameDistanceRacers(getMaxDistance());
    }

    private Distance getMaxDistance() {
        return racerDistanceMap
                .values()
                .stream()
                .max(Comparator.comparingInt(Distance::distance))
                .orElse(Distance.of());
    }

    private Collection<Racer> getSameDistanceRacers(Distance distance) {
        return getRacers()
                .stream()
                .filter(racer -> this.distance(racer).equals(distance))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundStatus that = (RoundStatus) o;
        return Objects.equals(racerDistanceMap, that.racerDistanceMap) &&
                racerDistanceMap.keySet().stream().allMatch(racer -> that.valueEquals(racer, racerDistanceMap.get(racer)));
    }

    private boolean valueEquals(Racer racer, Distance expectDistance) {
        return racerDistanceMap.get(racer).equals(expectDistance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racerDistanceMap, Arrays.deepHashCode(racerDistanceMap.values().toArray()));
    }
}
