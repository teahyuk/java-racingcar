package com.nextstep.teahyuk.racing.vo;

/**
 * com.nextstep.teahyuk.racing.vo.Racer class
 *
 * @author teahyuk
 */
public class Racer {
    private final String racerName;

    /**
     * make com.nextstep.teahyuk.racing.vo.Racer with racerName
     *
     * @param racerName
     * @throws IllegalArgumentException racerName cannot has specific char(':')
     */
    public Racer(String racerName) {
        if (racerName.contains(":")) {
            throw new IllegalArgumentException("racerName canNot have ':'");
        }
        this.racerName = racerName;
    }

    public String name() {
        return racerName;
    }
}
