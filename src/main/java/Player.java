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

    public int nextRound(int currentDistance) {
        return car.move() ? currentDistance + 1 : currentDistance;
    }
}
