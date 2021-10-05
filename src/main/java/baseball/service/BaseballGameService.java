package baseball.service;

import java.util.List;

import baseball.domain.HitNumber;
import baseball.domain.HitResult;
import baseball.service.evaluate.status.HitStatusEvaluator;

public class BaseballGameService implements IBaseballGameService {

	private final List<HitStatusEvaluator> hitStatusEvaluators;

	public BaseballGameService(List<HitStatusEvaluator> hitStatusEvaluators) {
		this.hitStatusEvaluators = hitStatusEvaluators;
	}

	@Override
	public HitResult evaluate(HitNumber number, HitNumber answer) {
		HitResult hitResult = HitResult.emptyResult();
		for (HitStatusEvaluator hitStatusEvaluator : hitStatusEvaluators) {
			hitResult = hitResult.append(hitStatusEvaluator.evaluate(number, answer));
		}

		return HitResult.from(hitResult);
	}

}
