package com.nextstep.teahyuk.racing.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String GET_RACER_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_COUNT_MSG = "시도할 회수는 몇 회 인가요?";

    Scanner scanner = new Scanner(System.in);

    public List<String> getRacers() {
        System.out.println(GET_RACER_MSG);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public int getRoundCount() {
        System.out.println(GET_COUNT_MSG);
        return Integer.parseInt(scanner.nextLine());
    }
}
