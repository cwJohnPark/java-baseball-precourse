package baseball;

import baseball.controller.IBaseballGameController;
import baseball.dto.HitResultDescription;
import baseball.exception.InvalidUserInputException;
import baseball.factory.BaseballGameFactory;
import baseball.utils.AnswerGenerator;
import nextstep.utils.Console;

public class BaseballGameApplication {

	private final IBaseballGameController gameController = BaseballGameFactory.createBaseballGameController();

	public static BaseballGameApplication createNewGame() {
		return new BaseballGameApplication();
	}

	public void start() {
		boolean continueGame = true;
		int answer = AnswerGenerator.createThreeDigits();

		while (continueGame) {
			continueGame = hit(answer);
		}
		System.out.println("3 개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	private boolean hit(int answer) {
		System.out.print("숫자를 입력해주세요: ");
		try {
			final HitResultDescription resultDescription = gameController.hit(toInteger(Console.readLine()), answer);
			System.out.println(resultDescription.getDescription());
			return !resultDescription.isEqualToAnswer();
		} catch (InvalidUserInputException e) {
			System.err.println(e.getMessage());
			return true;
		}
	}

	private int toInteger(String inputLiteral) {
		return Integer.parseInt(inputLiteral);
	}
}

