package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.utils.ArrayUtils;

public class HitNumber {

	private static final Set<Integer> VALID_DIGITS = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	private static final int DIGIT_LIMIT = 3;
	private final List<Integer> numbers;

	public HitNumber(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static HitNumber from(int input) {
		checkValidRange(input);
		checkValidDigitCount(input);

		checkNoRedundant(input);

		return new HitNumber(ArrayUtils.separateDigit(input));
	}

	private static void checkValidDigitCount(int input) {
		final List<Integer> digits = ArrayUtils.separateDigit(input);
		if (digits.size() != DIGIT_LIMIT) {
			throw new IllegalArgumentException();
		}

		if (!VALID_DIGITS.containsAll(digits)) {
			throw new IllegalArgumentException();
		}
	}

	private static void checkNoRedundant(int input) {
		final Set<Integer> checked = new HashSet<>();
		for (int i = 0; i < DIGIT_LIMIT; i++) {
			checked.add(input % 10);
			input /= 10;
		}

		if (checked.size() != DIGIT_LIMIT) {
			throw new IllegalArgumentException();
		}
	}

	private static void checkValidRange(int input) {
		int maxExclusive = Double.valueOf(Math.pow(10, DIGIT_LIMIT)).intValue();
		int minExclusive = 0;

		if (input >= maxExclusive || input <= minExclusive) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}
