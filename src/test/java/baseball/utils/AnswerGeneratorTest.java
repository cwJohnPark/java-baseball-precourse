package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerGeneratorTest {

	@Test
	@DisplayName("정답 랜덤 숫자 생성 값은 유효한 숫자여야 한다")
	void testAnswerGeneratorIsValid() {
		assertThatNoException()
			.isThrownBy(AnswerGenerator::createThreeDigits);
	}
}