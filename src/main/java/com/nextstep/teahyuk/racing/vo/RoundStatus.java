package com.nextstep.teahyuk.racing.vo;

import java.util.*;

public class RoundStatus {
    private final Map<Racer, Distance> racerDistanceMap;
    private final int s = 4;

    public RoundStatus(Map<Racer, Distance> racerDistanceHashMap) {
        this.racerDistanceMap = new HashMap<>(racerDistanceHashMap);
    }

    public Collection<Racer> getRacers() {
        return racerDistanceMap.keySet();
    }

    public Distance distance(Racer racer) {
        return racerDistanceMap.get(racer);
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

    public Distance getMaxDistance() {
        return racerDistanceMap
                .values()
                .stream()
                .max(Comparator.comparingInt(Distance::distance))
                .orElse(Distance.of());
    }

    @Override
    public int hashCode() {
        return Objects.hash(racerDistanceMap, Arrays.deepHashCode(racerDistanceMap.values().toArray()));
    }
}
