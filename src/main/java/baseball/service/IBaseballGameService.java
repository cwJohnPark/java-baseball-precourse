package baseball.service;

import baseball.domain.HitNumber;
import baseball.domain.HitResult;

public interface IBaseballGameService {

	HitResult evaluate(HitNumber number, HitNumber answer);
}
