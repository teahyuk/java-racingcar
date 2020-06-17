import com.nextstep.teahyuk.racing.Distance;
import com.nextstep.teahyuk.racing.GameManager;
import com.nextstep.teahyuk.racing.Player;
import com.nextstep.teahyuk.racing.RoundStatus;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class GameManagerTest {

    private static final Player player1 = new Player("racer1", 100);
    private static final Player player2 = new Player("racer2", 100);

    @Test
    void constructor() {
        assertThatCode(() -> new GameManager(player1, player2))
                .doesNotThrowAnyException();
    }

    @Test
    void firstRound() {
        GameManager gameManager = new GameManager(player1, player2);
        RoundStatus expectRound = new RoundStatus(Stream.of(player1.getRacer(), player2.getRacer())
                .collect(Collectors.toMap(Function.identity(), racer -> Distance.of())));
        assertThat(gameManager.firstRound())
                .isEqualTo(expectRound);
    }

    @Test
    void nextRound() {
        GameManager gameManager = new GameManager(player1, player2);
        RoundStatus firstRound = new RoundStatus(Stream.of(player1.getRacer(), player2.getRacer())
                .collect(Collectors.toMap(Function.identity(), racer -> Distance.of())));

        RoundStatus expectRound = new RoundStatus(Stream.of(player1.getRacer(), player2.getRacer())
                .collect(Collectors.toMap(Function.identity(), racer -> Distance.of(1))));

        assertThat(gameManager.nextRound(firstRound))
                .isEqualTo(expectRound);
    }

}