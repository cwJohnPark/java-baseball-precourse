package baseball.factory;

import java.util.Arrays;

import baseball.controller.BaseballGameController;
import baseball.controller.IBaseballGameController;
import baseball.service.BaseballGameService;
import baseball.service.evaluate.status.BallStatusEvaluator;
import baseball.service.evaluate.status.StrikeStatusEvaluator;

public class BaseballGameFactory {

	public static IBaseballGameController createBaseballGameController() {
		return new BaseballGameController(
			new BaseballGameService(
				Arrays.asList(
					new StrikeStatusEvaluator(),
					new BallStatusEvaluator())));
	}
}
