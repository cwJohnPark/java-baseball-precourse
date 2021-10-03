package baseball.domain;

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
		final int firstNumber = input / 100;
		final int secondNumber = input % 100 / 10;
		final int thirdNumber = input % 10 % 10;

		return new GameInput(firstNumber, secondNumber, thirdNumber);
	}

}
