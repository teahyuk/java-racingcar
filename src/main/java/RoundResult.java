import java.util.HashMap;
import java.util.Map;

public class RoundResult {
    private final Map<Racer, Distance> racerDistanceMap;

    public RoundResult(Map<Racer, Distance> racerDistanceHashMap) {
        this.racerDistanceMap = new HashMap<>(racerDistanceHashMap);
    }

    public Iterable<Racer> getRacers() {
        return racerDistanceMap.keySet();
    }

    public Distance distance(Racer racer) {
        return racerDistanceMap.get(racer);
    }
}
