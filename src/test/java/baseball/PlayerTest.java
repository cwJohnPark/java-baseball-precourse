package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class PlayerTest {

    private static MockedStatic<Randoms> randoms;

    int[] COMPUTER_BALLS = new int[] {4, 5, 6};

    @BeforeAll
    static void setUp() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    static void cleanUp() {
        randoms.close();
    }

    @ParameterizedTest
    @MethodSource("provideGameSetHit")
    void testHit(List<Integer> numbers, String resultText) {
        Player player = new Player(getComputerPlayer());

        HitResult result = player.hit(createBaseBalls(numbers));

        assertThat(result.getResultText()).isEqualTo(resultText);
    }

    private ComputerPlayer getComputerPlayer() {
        ComputerPlayer computerPlayer = new ComputerPlayer();

        when(Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(COMPUTER_BALLS[0], COMPUTER_BALLS[1], COMPUTER_BALLS[2]);
        computerPlayer.setRandomBaseBalls();
        return computerPlayer;
    }

    private BaseBalls createBaseBalls(List<Integer> numbers) {
        return BaseBalls.createBaseBalls(numbers);
    }

    private static Stream<Arguments> provideGameSetHit() {
        return Stream.of(
                Arguments.of(
                        Lists.newArrayList(4,2,3),
                        "1스트라이크"),
                Arguments.of(
                        Lists.newArrayList(2,4,3),
                        "1볼"),
                Arguments.of(
                        Lists.newArrayList(4,3,5),
                        "1볼 1스트라이크"),
                Arguments.of(
                        Lists.newArrayList(1,2,3),
                        "낫싱")
        );
    }
}
