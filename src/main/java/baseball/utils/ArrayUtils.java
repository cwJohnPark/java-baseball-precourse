package baseball.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {

	public static List<Integer> separateDigit(int number) {
		List<Integer> result = new ArrayList<>();
		while (number > 0) {
			result.add(number % 10);
			number /= 10;
		}
		Collections.reverse(result);
		return result;
	}

	public static int reduceToInt(List<Integer> numbers) {
		int result = 0;
		for (int i = 0; i < numbers.size(); i++) {
			result += numbers.get(i) * Math.pow(10, numbers.size() - 1 - i);
		}

		return result;
	}
}
