package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.exception.InvalidUserInputException;

class HitNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {123, 456, 789})
	@DisplayName("사용자로부터 1부터 9까지의 서로 다른 숫자를 3개를 받을 수 있다")
	void testValidUserInput(int userInput) {
		assertThatNoException()
			.isThrownBy(() -> HitNumber.from(userInput));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 12, 980, 11, 99, 1000, -123, Integer.MAX_VALUE, Integer.MIN_VALUE})
	@DisplayName("사용자가 1부터 9 사이의 숫자가 아닌 값을 입력하면 오류를 반환한다")
	void testUserInvalidInput(int userInput) {
		assertThatExceptionOfType(InvalidUserInputException.class)
			.isThrownBy(() -> HitNumber.from(userInput));
	}

	@ParameterizedTest
	@ValueSource(ints = {111, 222, 999, 122, 311, 919})
	@DisplayName("같은 숫자가 중복되면 오류를 반환한다")
	void testRedundantInputNumber(int userInput) {
		assertThatExceptionOfType(InvalidUserInputException.class)
			.isThrownBy(() -> HitNumber.from(userInput));
	}
}