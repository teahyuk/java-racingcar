package com.nextstep.teahyuk.racing.result;

import com.nextstep.teahyuk.racing.vo.Distance;
import com.nextstep.teahyuk.racing.vo.Racer;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RoundResultTest {

    private static final Racer racer1 = new Racer("racer1");
    private static final Racer racer2 = new Racer("racer2");

    @Test
    void roundResult() {
        assertThatCode(() -> new RoundResult(new HashMap<>()))
                .doesNotThrowAnyException();
    }

    @Test
    void getRacers() {
        Map<Racer, Distance> racerMap = Stream.of(racer1, racer2)
                .collect(Collectors.toMap(Function.identity(), racer -> Distance.of()));
        RoundResult roundResult = new RoundResult(racerMap);
        assertThat(roundResult.getRacers())
                .containsAll(racerMap.keySet());
    }

    @Test
    void distance() {
        Map<Racer, Distance> racerMap = getRacerDistanceMap();

        RoundResult roundResult = new RoundResult(racerMap);
        assertThat(roundResult.distance(racer1))
                .isEqualTo(racerMap.get(racer1));
        assertThat(roundResult.distance(racer2))
                .isEqualTo(racerMap.get(racer2));
    }

    @Test
    void getMaxDistanceRacers() {
        Map<Racer, Distance> racerMap = getRacerDistanceMap();
        Racer racer3 = new Racer("racer3");
        racerMap.put(racer3, racerMap.get(racer2));

        RoundResult roundResult = new RoundResult(racerMap);
        assertThat(roundResult.getMaxDistanceRacers())
                .containsExactlyInAnyOrder(racer2, racer3);
    }

    private Map<Racer, Distance> getRacerDistanceMap() {
        Map<Racer, Distance> racerMap = new HashMap<>();
        Distance racer1Distance = Distance.of(1);
        Distance racer2Distance = Distance.of(2);
        racerMap.put(racer1, racer1Distance);
        racerMap.put(racer2, racer2Distance);
        return racerMap;
    }
}
