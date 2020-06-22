package com.nextstep.teahyuk.racing.vo;

/**
 * @author teahyuk
 * @since 1.0
 */
public class Racer {
    private final String racerName;

    /**
     * @param racerName racerName
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
