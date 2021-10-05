package baseball.service.evaluate.status;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.domain.HitNumber;
import baseball.domain.HitStatusCount;
import baseball.exception.InvalidUserInputException;

class BallStatusEvaluatorTest {

	BallStatusEvaluator ballStatusEvaluator = new BallStatusEvaluator();

	static Stream<Arguments> provideBallHitNumber() throws InvalidUserInputException {
		return Stream.of(
			Arguments.of(HitNumber.from(123), HitNumber.from(123), 0),
			Arguments.of(HitNumber.from(123), HitNumber.from(456), 0),
			Arguments.of(HitNumber.from(123), HitNumber.from(341), 2),
			Arguments.of(HitNumber.from(123), HitNumber.from(312), 3)
		);
	}

	@ParameterizedTest
	@MethodSource("provideBallHitNumber")
	@DisplayName("Ball 판정 테스트")
	void testBallHitNumberCount(HitNumber number, HitNumber other, int expectedCount) {
		final HitStatusCount statusCount = ballStatusEvaluator.evaluate(number, other);

		assertThat(statusCount.getCount()).isEqualTo(expectedCount);
	}
}