package com.nextstep.teahyuk.racing.vo;

/**
 * Game participant
 *
 * <p>It has Racer and Car</p>
 *
 * @author teahyuk
 * @since 1.0
 */
public class Player {
    private final Racer racer;
    private final Car car;

    public Player(String racerName) {
        this(new Racer(racerName), new Car());
    }

    Player(String racerName, int canGoPercent) {
        this(new Racer(racerName), new Car(canGoPercent));
    }

    private Player(Racer racer, Car car) {
        this.racer = racer;
        this.car = car;
    }

    public Distance nextRound(Distance currentDistance) {
        return car.movable() ? currentDistance.add() : currentDistance;
    }

    public Racer getRacer() {
        return racer;
    }
}
