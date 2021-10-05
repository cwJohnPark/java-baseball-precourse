package baseball.service.evaluate.status;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.domain.HitNumber;
import baseball.domain.HitStatusCount;

class NothingStatusEvaluatorTest {

	NothingStatusEvaluator nothingStatusEvaluator = new NothingStatusEvaluator();

	static Stream<Arguments> provideNothingHitNumber() throws Exception {
		return Stream.of(
			Arguments.of(HitNumber.from(123), HitNumber.from(145), 0),
			Arguments.of(HitNumber.from(123), HitNumber.from(345), 0),
			Arguments.of(HitNumber.from(123), HitNumber.from(456), 1),
			Arguments.of(HitNumber.from(123), HitNumber.from(789), 1)
		);
	}

	@ParameterizedTest
	@MethodSource("provideNothingHitNumber")
	@DisplayName("Nothing 판정 테스트")
	void testBallHitNumberCount(HitNumber number, HitNumber other, int expectedCount) {
		final HitStatusCount statusCount = nothingStatusEvaluator.evaluate(number, other);

		assertThat(statusCount.getCount()).isEqualTo(expectedCount);
	}
}