package baseball.service;

import java.util.List;

import baseball.domain.HitNumber;
import baseball.domain.HitResult;
import baseball.service.evaluate.answer.AnswerEvaluator;
import baseball.service.evaluate.status.HitStatusEvaluator;

public class BaseballGameService implements IBaseballGameService {

	private final List<HitStatusEvaluator> hitStatusEvaluators;
	private final AnswerEvaluator answerEvaluator;

	public BaseballGameService(List<HitStatusEvaluator> hitStatusEvaluators, AnswerEvaluator answerEvaluator) {
		this.hitStatusEvaluators = hitStatusEvaluators;
		this.answerEvaluator = answerEvaluator;
	}

	@Override
	public HitResult evaluate(HitNumber number, HitNumber answer) {
		HitResult hitResult = HitResult.emptyResult();
		for (HitStatusEvaluator hitStatusEvaluator : hitStatusEvaluators) {
			hitResult = hitResult.append(hitStatusEvaluator.evaluate(number, answer));
		}

		return HitResult.of(hitResult, answerEvaluator.isCorrectAnswer(number, answer));
	}

}
