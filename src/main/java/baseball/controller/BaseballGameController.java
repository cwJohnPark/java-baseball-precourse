package baseball.controller;

import baseball.domain.GameInput;

public class BaseballGameController implements IBaseballGameController {

	public BaseballGameController() {
	}

	@Override
	public void hit(int input) {
		GameInput.from(input);
	}
}
