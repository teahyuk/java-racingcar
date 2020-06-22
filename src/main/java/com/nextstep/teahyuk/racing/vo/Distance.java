package com.nextstep.teahyuk.racing.vo;

import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>Means the distance from the starting point</p>
 *
 * @author teahyuk
 * @since 1.0
 */
public class Distance {
    private final int distance;

    private final static ConcurrentMap<Integer, Distance> cacheMap = IntStream.range(0, 11)
            .boxed()
            .collect(Collectors.toConcurrentMap(Function.identity(), Distance::new));

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance of() {
        return cacheMap.get(0);
    }

    public static Distance of(int distance) {
        cacheMap.putIfAbsent(distance, new Distance(distance));
        return cacheMap.get(distance);
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

    @Override
    public String toString() {
        return "Distance{" +
                "distance=" + distance +
                '}';
    }
}
