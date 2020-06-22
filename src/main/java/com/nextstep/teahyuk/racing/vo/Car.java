package com.nextstep.teahyuk.racing.vo;

import java.util.Random;

/**
 * Car service with movable
 *
 * <p>This Class create with movable percent and service canMove each call movable method</p>
 * @author teahyuk
 * @since 1.0
 */
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
