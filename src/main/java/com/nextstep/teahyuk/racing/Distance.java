package com.nextstep.teahyuk.racing;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Distance {
    private final int distance;

    private final static Map<Integer, Distance> cacheMap = IntStream.range(0, 11)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), Distance::new));

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance of() {
        return cacheMap.get(0);
    }

    static Distance of(int distance){
        return cacheMap.putIfAbsent(distance, new Distance(distance));
    }

    public int distance() {
        return distance;
    }

    public Distance add() {
        return of(distance + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
