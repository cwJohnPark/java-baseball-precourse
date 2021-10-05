package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class AnswerGenerator {

	public static int createThreeDigits() {

		List<Integer> selectedNumbers = new ArrayList<>();
		while (selectedNumbers.size() != 3) {
			add(selectedNumbers, Randoms.pickNumberInRange(1, 9));
		}

		return ArrayUtils.reduceToInt(selectedNumbers);
	}

	private static void add(List<Integer> selectedNumbers, int number) {
		if (!selectedNumbers.contains(number)) {
			selectedNumbers.add(number);
		}
	}
}
