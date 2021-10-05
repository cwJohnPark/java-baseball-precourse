package baseball.service.evaluate.answer;

import baseball.domain.HitNumber;

public interface AnswerEvaluator {

	boolean isCorrectAnswer(HitNumber number, HitNumber other);
}
