package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArrayUtilsTest {

	@ParameterizedTest
	@MethodSource("provideNumberAndArrays")
	@DisplayName("자릿수별로 숫자를 분리하여 리스트에 담을 수 있다")
	void testSeparateDigits(int number, List<Integer> answer) {
		final List<Integer> separatedDigits = ArrayUtils.separateDigit(number);
		assertThat(separatedDigits).containsExactlyElementsOf(answer);
	}

	@ParameterizedTest
	@MethodSource("provideNumberAndArrays")
	@DisplayName("숫자가 담긴 배열 리스트를 integer로 변환할 수 있다.")
	void testReduceToInteger(int expectedNumber, List<Integer> numbers) {
		final int reducedInt = ArrayUtils.reduceToInt(numbers);
		assertThat(reducedInt).isEqualTo(expectedNumber);
	}

	static Stream<Arguments> provideNumberAndArrays() {
		return Stream.of(
			Arguments.of(100, Arrays.asList(1, 0, 0)),
			Arguments.of(1000, Arrays.asList(1, 0, 0, 0)),
			Arguments.of(1, Arrays.asList(1)),
			Arguments.of(1234, Arrays.asList(1, 2, 3, 4)),
			Arguments.of(99999, Arrays.asList(9, 9, 9, 9, 9))
		);
	}
}