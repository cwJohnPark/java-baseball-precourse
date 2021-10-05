package baseball.controller;

import baseball.dto.HitResultDescription;
import baseball.exception.InvalidUserInputException;

public interface IBaseballGameController {
	HitResultDescription hit(int input, int answer) throws InvalidUserInputException;
}
