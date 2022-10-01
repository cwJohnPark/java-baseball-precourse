package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer {

    private final static int BASEBALL_MIN = 1;
    private final static int BASEBALL_MAX = 9;
    private final static int BASEBALL_COUNT = 3;

    private BaseBalls baseBalls;

    public ComputerPlayer() {
        baseBalls = new BaseBalls(new ArrayList<>());
    }

    public void selectRandomBaseBalls() {
        List<Integer> ballNumbers = Randoms.pickUniqueNumbersInRange(BASEBALL_MIN, BASEBALL_MAX, BASEBALL_COUNT);
        baseBalls = BaseBalls.createBaseBalls(ballNumbers);
    }

    public BaseBalls getBaseBalls() {
        return baseBalls;
    }
}
