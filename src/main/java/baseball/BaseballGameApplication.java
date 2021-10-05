package baseball;

import baseball.controller.IBaseballGameController;
import baseball.dto.HitResultDescription;
import baseball.exception.InvalidUserInputException;
import baseball.factory.BaseballGameFactory;
import nextstep.utils.Console;

public class BaseballGameApplication {

	private final IBaseballGameController gameController = BaseballGameFactory.createBaseballGameController();
	private final int answer = 123;

	public static BaseballGameApplication createNewGame() {
		return new BaseballGameApplication();
	}

	public void start() {
		hit();
	}

	private void hit() {
		System.out.print("숫자를 입력해주세요: ");
		try {
			final HitResultDescription resultDescription = gameController.hit(toInteger(Console.readLine()), answer);
			System.out.println(resultDescription.getDescription());
		} catch (InvalidUserInputException e) {
			System.err.println(e.getMessage());
		}
	}

	private int toInteger(String inputLiteral) {
		return Integer.parseInt(inputLiteral);
	}
}

