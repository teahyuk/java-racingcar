import com.nextstep.teahyuk.racing.Distance;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {
    @Test
    void equals(){
        Distance distance = Distance.of();
        assertThat(distance)
                .isEqualTo(Distance.of());
    }

    @Test
    void getDistance(){
        assertThat(Distance.of().distance())
                .isEqualTo(0);
    }

    @Test
    void add(){
        assertThat(Distance.of().add().distance())
                .isEqualTo(1);
    }
}