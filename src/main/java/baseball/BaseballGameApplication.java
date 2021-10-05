package baseball;

import java.util.Arrays;

import baseball.domain.HitNumber;
import baseball.exception.InvalidUserInputException;
import nextstep.utils.Console;

public class BaseballGameApplication {

	public static BaseballGameApplication createNewGame() {
		return new BaseballGameApplication();
	}

	public void start() {
		hit();
	}

	private void hit() {
		System.out.print("숫자를 입력해주세요: ");
		try {
			HitNumber input = HitNumber.from(toInteger(Console.readLine()));
			System.out.println("입력한 값 = " + Arrays.toString(input.getNumbers().toArray()));
		} catch (InvalidUserInputException e) {
			System.err.println(e.getMessage());
		}
	}

	private int toInteger(String inputLiteral) {
		return Integer.parseInt(inputLiteral);
	}
}

