package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseBallConstants.*;

public class ComputerPlayer {

    private BaseBalls baseBalls;

    public ComputerPlayer() {
        baseBalls = BaseBalls.createBaseBalls();
    }

    public void setRandomBaseBalls() {
        List<Integer> ballNumbers = getRandoms();
        baseBalls = BaseBalls.createBaseBalls(ballNumbers);
    }

    private List<Integer> getRandoms() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < BASEBALL_COUNT; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(BASEBALL_MIN, BASEBALL_MAX));
        }
        return randomNumbers;
    }

    public BaseBalls getBaseBalls() {
        return baseBalls;
    }

    public Hints hit(BaseBalls playerBaseBalls) {
        return baseBalls.hit(playerBaseBalls);
    }
}
