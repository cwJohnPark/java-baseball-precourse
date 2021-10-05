package baseball.controller;

import java.util.List;

import baseball.domain.HitNumber;
import baseball.domain.HitResult;
import baseball.domain.HitStatusCount;
import baseball.dto.HitResultDescription;
import baseball.exception.InvalidUserInputException;
import baseball.service.IBaseballGameService;
import baseball.service.evaluate.status.NothingStatusEvaluator;

public class BaseballGameController implements IBaseballGameController {

	private final IBaseballGameService baseballGameService;

	public BaseballGameController(IBaseballGameService baseballGameService) {
		this.baseballGameService = baseballGameService;
	}

	@Override
	public HitResultDescription hit(int input, int answer) throws InvalidUserInputException {
		final HitResult hitResult = baseballGameService.evaluate(HitNumber.from(input), HitNumber.from(answer));

		if (isNothing(hitResult)) {
			return HitResultDescription.createWrongAnswerWithNoCountDisplay(hitResult);
		}

		return hitResult.isCorrectAnswer() ? HitResultDescription.createCorrectAnswer(hitResult) :
			HitResultDescription.createWrongAnswer(hitResult);
	}

	private boolean isNothing(HitResult hitResult) {
		final List<HitStatusCount> hitStatusCounts = HitStatusCount.removeNoCount(hitResult.getHitStatusCountList());
		return hitStatusCounts.size() == 1
			&& hitStatusCounts.get(0).getHitStatus() == NothingStatusEvaluator.NOTHING;
	}

}
