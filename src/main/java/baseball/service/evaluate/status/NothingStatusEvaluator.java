package baseball.service.evaluate.status;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.domain.HitNumber;
import baseball.domain.HitStatus;
import baseball.domain.HitStatusCount;

public class NothingStatusEvaluator implements HitStatusEvaluator {

	public static final HitStatus NOTHING = HitStatus.of("Nothing", "낫싱");

	@Override
	public HitStatusCount evaluate(HitNumber number, HitNumber other) {
		final List<Integer> numbers = number.getNumbers();
		Set<Integer> allOtherNumbers = new HashSet<>(other.getNumbers());
		final boolean isAnyRemoved = allOtherNumbers.removeIf(numbers::contains);

		return isAnyRemoved ? HitStatusCount.of(0, NOTHING) : HitStatusCount.of(1, NOTHING);
	}

}
