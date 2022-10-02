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
                        BaseBalls.createBaseBalls(3,1,2),
                        BaseBalls.createBaseBalls(3,9,1),
                        createHints(Hint.BALL, Hint.STRIKE)),
                Arguments.of(
                        BaseBalls.createBaseBalls(3,1,2),
                        BaseBalls.createBaseBalls(4,5,6),
                        createHints(Hint.NOTHING)),
                Arguments.of(
                        BaseBalls.createBaseBalls(4,5,6),
                        BaseBalls.createBaseBalls(4,5,6),
                        createHints(Hint.STRIKE, Hint.STRIKE, Hint.STRIKE))
                );
    }

    private static Hints createHints(Hint ...addedHints) {
        Hints hints = Hints.createEmpty();
        for (Hint addedHint : addedHints) {
            hints.add(addedHint);
        }
        return hints;
    }

}
