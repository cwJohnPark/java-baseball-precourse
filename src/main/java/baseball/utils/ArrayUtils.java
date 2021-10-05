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

}
