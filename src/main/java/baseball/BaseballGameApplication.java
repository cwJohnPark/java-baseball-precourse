package baseball;

import static baseball.code.ApplicationCode.*;

import baseball.code.ApplicationCode;
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
			continueGame = hit(answer) != ANSWERED;
		}
		System.out.println("3 개의 숫자를 모두 맞히셨습니다! 게임 끝");

		if (restart() == RESTART) {
			start();
		}
	}

	private ApplicationCode hit(int answer) {
		System.out.print("숫자를 입력해주세요: ");
		try {
			final HitResultDescription resultDescription = gameController.hit(toInteger(Console.readLine()), answer);
			System.out.println(resultDescription.getDescription());
			return resultDescription.isEqualToAnswer() ? ANSWERED : CONTINUE;
		} catch (InvalidUserInputException e) {
			System.err.println(e.getMessage());
			return CONTINUE;
		}
	}

	private ApplicationCode restart() {
		boolean isInvalidInput = true;
		int input = 0;
		while (isInvalidInput) {
			System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = getRestartInput();
			isInvalidInput = input != 1 && input != 2;
		}
		return input == 1 ? RESTART : TERMINATE;
	}

	private int getRestartInput() {
		try {
			return toInteger(Console.readLine());
		} catch (InvalidUserInputException e) {
			System.err.println(e.getMessage());
			return -1;
		}
	}

	private int toInteger(String inputLiteral) throws InvalidUserInputException {
		try {
			return Integer.parseInt(inputLiteral);
		} catch (NumberFormatException nfe) {
			throw new InvalidUserInputException(inputLiteral);
		}
	}
}

