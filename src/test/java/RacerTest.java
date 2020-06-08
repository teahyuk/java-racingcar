import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacerTest {

    @Test
    void name() {
        String racerName = "tester";
        Racer racer = new Racer(racerName);
        assertThat(racer.name())
                .isEqualTo(racerName);
    }

    @Test
    void nameException() {
        String racerName = "tester:";
        assertThatThrownBy(() -> new Racer(racerName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}