package baseball.service.evaluate.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.domain.HitNumber;
import baseball.domain.HitStatus;
import baseball.domain.HitStatusCount;

public class BallStatusEvaluator implements HitStatusEvaluator {

	public static final HitStatus BALL = HitStatus.of("Ball", "볼");

	@Override
	public HitStatusCount evaluate(HitNumber number, HitNumber other) {
		final List<Integer> numbers = number.getNumbers();
		final Map<Integer, Integer> otherNumberIndexMap = toIndexMap(other.getNumbers());

		int count = 0;
		for (int i = 0; i < numbers.size(); i++) {
			count += checkIfHasDifferentIndex(i, numbers.get(i), otherNumberIndexMap) ? 1 : 0;
		}
		return HitStatusCount.of(count, BALL);
	}

	private boolean checkIfHasDifferentIndex(int index, int numbers, Map<Integer, Integer> indexMap) {
		if (!indexMap.containsKey(numbers)) {
			return false;
		}
		return indexMap.get(numbers) != index;
	}

	private Map<Integer, Integer> toIndexMap(List<Integer> numbers) {
		Map<Integer, Integer> indexMap = new HashMap<>(numbers.size());
		for (int i = 0; i < numbers.size(); i++) {
			indexMap.put(numbers.get(i), i);
		}
		return indexMap;
	}
}
