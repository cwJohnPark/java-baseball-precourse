package baseball.exception;

import static java.lang.String.*;

public class InvalidUserInputException extends RuntimeException {

	public InvalidUserInputException(int input) {
		super(format("[ERROR] 숫자는 1부터 9까지의 숫자를 중복없이 3자리로 입력해야 합니다. 입력한 숫자 : '%d'", input));
	}
}
