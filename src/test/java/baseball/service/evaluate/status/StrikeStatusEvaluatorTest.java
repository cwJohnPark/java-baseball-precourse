package baseball.service.evaluate.status;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.domain.HitNumber;
import baseball.domain.HitStatusCount;

class StrikeStatusEvaluatorTest {

	StrikeStatusEvaluator strikeStatusEvaluator = new StrikeStatusEvaluator();

	static Stream<Arguments> provideStrikeHitNumber() throws Exception {
		return Stream.of(
			Arguments.of(HitNumber.from(123), HitNumber.from(123), 3),
			Arguments.of(HitNumber.from(123), HitNumber.from(124), 2),
			Arguments.of(HitNumber.from(123), HitNumber.from(134), 1),
			Arguments.of(HitNumber.from(123), HitNumber.from(456), 0),
			Arguments.of(HitNumber.from(123), HitNumber.from(341), 0),
			Arguments.of(HitNumber.from(123), HitNumber.from(312), 0)
		);
	}

	static Stream<Arguments> provideAnswerHitNumber() throws Exception {
		return Stream.of(
			Arguments.of(HitNumber.from(123), HitNumber.from(123), true),
			Arguments.of(HitNumber.from(789), HitNumber.from(789), true),
			Arguments.of(HitNumber.from(123), HitNumber.from(134), false),
			Arguments.of(HitNumber.from(123), HitNumber.from(456), false),
			Arguments.of(HitNumber.from(123), HitNumber.from(341), false),
			Arguments.of(HitNumber.from(123), HitNumber.from(312), false)
		);
	}

	@ParameterizedTest
	@MethodSource("provideStrikeHitNumber")
	@DisplayName("Strike 판정 테스트")
	void testBallHitNumberCount(HitNumber number, HitNumber other, int expectedCount) {
		final HitStatusCount statusCount = strikeStatusEvaluator.evaluate(number, other);

		assertThat(statusCount.getCount()).isEqualTo(expectedCount);
	}

	@ParameterizedTest
	@MethodSource("provideAnswerHitNumber")
	@DisplayName("정답 판정 테스트")
	void testAnswer(HitNumber number, HitNumber other, boolean exepectedAnswer) {
		final boolean isCorrectAnswer = strikeStatusEvaluator.isCorrectAnswer(number, other);
		assertThat(isCorrectAnswer).isEqualTo(exepectedAnswer);
	}
}