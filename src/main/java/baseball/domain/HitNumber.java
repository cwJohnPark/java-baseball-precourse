package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import baseball.exception.InvalidUserInputException;
import baseball.utils.ArrayUtils;

public class HitNumber {

	private static final Set<Integer> VALID_DIGITS = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	private static final int DIGIT_LIMIT = 3;
	private final List<Integer> numbers;

	public HitNumber(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public static HitNumber from(int input) throws InvalidUserInputException {
		checkValidRange(input);
		checkValidDigitCount(input);
		checkNoRedundant(input);

		return new HitNumber(ArrayUtils.separateDigit(input));
	}

	private static void checkValidDigitCount(int input) throws InvalidUserInputException {
		final List<Integer> digits = ArrayUtils.separateDigit(input);
		if (digits.size() != DIGIT_LIMIT) {
			throw new InvalidUserInputException(input);
		}

		if (!VALID_DIGITS.containsAll(digits)) {
			throw new InvalidUserInputException(input);
		}
	}

	private static void checkNoRedundant(int input) throws InvalidUserInputException {
		final Set<Integer> checked = new HashSet<>();
		int checkedNumber = input;
		for (int i = 0; i < DIGIT_LIMIT; i++) {
			checked.add(checkedNumber % 10);
			checkedNumber /= 10;
		}

		if (checked.size() != DIGIT_LIMIT) {
			throw new InvalidUserInputException(input);
		}
	}

	private static void checkValidRange(int input) throws InvalidUserInputException {
		int maxExclusive = Double.valueOf(Math.pow(10, DIGIT_LIMIT)).intValue();
		int minExclusive = 0;

		if (input >= maxExclusive || input <= minExclusive) {
			throw new InvalidUserInputException(input);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		HitNumber hitNumber = (HitNumber)o;
		return Arrays.equals(this.numbers.toArray(), hitNumber.numbers.toArray());
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
