package baseball.domain;

import baseball.exception.InvalidUserInputException;

public class GameInput {

	private int firstNumber;
	private int secondNumber;
	private int thirdNumber;

	public GameInput(int firstNumber, int secondNumber, int thirdNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.thirdNumber = thirdNumber;
	}

	public static GameInput from(int input) {
		if (input > 999 || input < 1 || input / 100 == 0 || input % 100 / 10 == 0) {
			throw new InvalidUserInputException(input);
		}

		final int firstNumber = input / 100;
		final int secondNumber = input % 100 / 10;
		final int thirdNumber = input % 10 % 10;

		if (firstNumber == secondNumber || firstNumber == thirdNumber || secondNumber == thirdNumber) {
			throw new InvalidUserInputException(input);
		}

		return new GameInput(firstNumber, secondNumber, thirdNumber);
	}

}
