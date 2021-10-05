package baseball.controller;

import baseball.domain.HitNumber;
import baseball.dto.HitResultDescription;
import baseball.exception.InvalidUserInputException;
import baseball.service.IBaseballGameService;

public class BaseballGameController implements IBaseballGameController {

	private final IBaseballGameService baseballGameService;

	public BaseballGameController(IBaseballGameService baseballGameService) {
		this.baseballGameService = baseballGameService;
	}

	@Override
	public HitResultDescription hit(int input, int answer) throws InvalidUserInputException {
		return HitResultDescription.from(
			baseballGameService.evaluate(HitNumber.from(input), HitNumber.from(answer)));
	}

}
