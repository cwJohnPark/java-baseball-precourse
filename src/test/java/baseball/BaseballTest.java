package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    @ParameterizedTest
    @MethodSource("provideBaseBalls")
    void testHitBaseball(BaseBalls playerBall, BaseBalls computerBall, Hints expectedHints) {
        Hints hints = computerBall.hit(playerBall);

        assertThat(hints).isEqualTo(expectedHints);
    }

    private static Stream<Arguments> provideBaseBalls() {
        return Stream.of(
                Arguments.of(
                        new BaseBalls(
                                new BaseBall(3, 1),
                                new BaseBall(1, 2),
                                new BaseBall(2, 3)),
                        new BaseBalls(
                                new BaseBall(3, 1),
                                new BaseBall(9, 2),
                                new BaseBall(1, 3)),
                        new Hints(Hint.BALL, Hint.STRIKE)),
                Arguments.of(
                        new BaseBalls(
                                new BaseBall(3, 1),
                                new BaseBall(1, 2),
                                new BaseBall(2, 3)),
                        new BaseBalls(
                                new BaseBall(4, 1),
                                new BaseBall(5, 2),
                                new BaseBall(6, 3)),
                        new Hints(Hint.NOTHING)),
                Arguments.of(
                        new BaseBalls(
                                new BaseBall(4, 1),
                                new BaseBall(5, 2),
                                new BaseBall(6, 3)),
                        new BaseBalls(
                                new BaseBall(4, 1),
                                new BaseBall(5, 2),
                                new BaseBall(6, 3)),
                        new Hints(Hint.STRIKE, Hint.STRIKE, Hint.STRIKE))
                );
    }

}
