package com.nextstep.teahyuk.racing;

/**
 * com.nextstep.teahyuk.racing.Racer class
 * @author teahyuk
 */
public class Racer {
    private final String racerName;

    /**
     * make com.nextstep.teahyuk.racing.Racer with racerName
     * @param racerName
     * @exception IllegalArgumentException racerName cannot has specific char(':')
     */
    public Racer(String racerName) {
        if(racerName.contains(":")){
            throw new IllegalArgumentException("racerName canNot have ':'");
        }
        this.racerName = racerName;
    }

    public String name() {
        return racerName;
    }
}
