package com.nextstep.teahyuk.racing.vo;

import java.util.Random;

public class Car {
    private static final int DEFAULT_GO_PERCENT = 40;

    private final int canMoveRate;
    private final Random random;

    public Car() {
        this(DEFAULT_GO_PERCENT);
    }

    Car(int canGoPercent) {
        this.canMoveRate = canGoPercent;
        this.random = new Random();
    }

    public boolean movable() {
        return random.nextInt(100) < canMoveRate;
    }
}
