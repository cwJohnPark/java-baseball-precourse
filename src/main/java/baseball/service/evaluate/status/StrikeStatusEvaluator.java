package baseball.service.evaluate.status;

import java.util.List;

import baseball.domain.HitNumber;
import baseball.domain.HitStatus;
import baseball.domain.HitStatusCount;
import baseball.service.evaluate.answer.AnswerEvaluator;

public class StrikeStatusEvaluator implements HitStatusEvaluator, AnswerEvaluator {

	public static final HitStatus STRIKE = HitStatus.of("Strike", "스트라이크");
	private static final int ANSWER_COUNT = 3;

	@Override
	public HitStatusCount evaluate(HitNumber number, HitNumber other) {
		final List<Integer> numbers = number.getNumbers();
		final List<Integer> otherNumbers = other.getNumbers();

		int count = 0;
		for (int i = 0; i < numbers.size(); i++) {
			count += numbers.get(i).equals(otherNumbers.get(i)) ? 1 : 0;
		}
		return HitStatusCount.of(count, STRIKE);
	}

	@Override
	public boolean isCorrectAnswer(HitNumber number, HitNumber other) {
		return evaluate(number, other).getCount() == ANSWER_COUNT;
	}
}
