package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerPlayer {

    private final static int BASEBALL_MIN = 1;
    private final static int BASEBALL_MAX = 9;
    private final static int BASEBALL_COUNT = 3;

    private BaseBalls baseBalls;

    public ComputerPlayer() {
        baseBalls = BaseBalls.createBaseBalls();
    }

    public void setRandomBaseBalls() {
        List<Integer> ballNumbers = Randoms.pickUniqueNumbersInRange(BASEBALL_MIN, BASEBALL_MAX, BASEBALL_COUNT);
        baseBalls = BaseBalls.createBaseBalls(ballNumbers);
    }

    public BaseBalls getBaseBalls() {
        return baseBalls;
    }

    public Hints hit(BaseBalls playerBaseBalls) {
        return baseBalls.hit(playerBaseBalls);
    }
}
