package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HitNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {123, 456, 789})
	@DisplayName("사용자로부터 1부터 9까지의 서로 다른 숫자를 3개를 받을 수 있다")
	void testValidUserInput(int userInput) {
		assertThatNoException()
			.isThrownBy(() -> HitNumber.from(userInput));
	}

}