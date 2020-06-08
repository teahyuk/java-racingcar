/**
 * Racer class
 * @author teahyuk
 */
public class Racer {
    private final String racerName;

    /**
     * make Racer with racerName
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
