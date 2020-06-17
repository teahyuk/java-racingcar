package com.nextstep.teahyuk.racing;

import com.nextstep.teahyuk.racing.vo.Distance;
import com.nextstep.teahyuk.racing.vo.Racer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundStatus that = (RoundStatus) o;
        return Objects.equals(racerDistanceMap, that.racerDistanceMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racerDistanceMap);
    }
}
