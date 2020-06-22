package com.nextstep.teahyuk.racing.ui;

import com.nextstep.teahyuk.racing.result.RoundResult;
import com.nextstep.teahyuk.racing.vo.Distance;
import com.nextstep.teahyuk.racing.vo.Racer;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Output {
    private static final String ROUND_RESULT_MSG = "실행 결과";
    private static final String ROUND_RESULT_FORMAT = "%s : %s";
    private static final String DISTANCE_FORMAT = "-";
    private static final String WINNER_FORMAT = "가 최종 우승 했 습니다.";
    private static final String WINNER_SPLIT_FORMAT = ",";

    public void printRound(List<RoundResult> roundResults) {
        System.out.println(ROUND_RESULT_MSG);
        roundResults.forEach(this::printSingleRound);
    }

    private void printSingleRound(RoundResult roundResult) {
        roundResult.getRacers()
                .forEach(racer -> System.out.println(String.format(ROUND_RESULT_FORMAT, racer.name(), getDistanceString(roundResult.distance(racer)))));
        System.out.println();
    }

    private String getDistanceString(Distance distance) {
        return IntStream.range(0, distance.distance())
                .mapToObj(dist -> DISTANCE_FORMAT)
                .collect(Collectors.joining());
    }

    public void printWinner(Collection<Racer> racers) {
        System.out.println(racers.stream()
                .map(Racer::name)
                .collect(Collectors.joining(WINNER_SPLIT_FORMAT, "", WINNER_FORMAT)));
    }
}
