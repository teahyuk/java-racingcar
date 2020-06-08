import java.util.Random;

public class Car {
    private final int canMoveRate;
    private final Random random;

    public Car(){
        this(40);
    }

    Car(int canMoveRate) {
        this.canMoveRate = canMoveRate;
        this.random = new Random();
    }

    public boolean move() {
        return random.nextInt(100) < canMoveRate;
    }
}
