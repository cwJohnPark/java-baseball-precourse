package baseball.service.evaluate.status;

import baseball.domain.HitNumber;
import baseball.domain.HitStatusCount;

public interface HitStatusEvaluator {

	HitStatusCount evaluate(HitNumber number, HitNumber other);

}
