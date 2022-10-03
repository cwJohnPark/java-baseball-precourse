package baseball;

import baseball.utils.NumberUtils;

import java.util.List;

import static baseball.BaseBallConstants.BASEBALL_COUNT;

public class ComputerPlayer {

    private BaseBalls baseBalls;

    public ComputerPlayer() {
        baseBalls = BaseBalls.createBaseBalls();
    }

    public void setRandomBaseBalls() {
        List<Integer> ballNumbers = NumberUtils.getUniqueNumbers(BASEBALL_COUNT);
        baseBalls = BaseBalls.createBaseBalls(ballNumbers);
    }

    public BaseBalls getBaseBalls() {
        return baseBalls;
    }

    public Hints hit(BaseBalls playerBaseBalls) {
        return baseBalls.hit(playerBaseBalls);
    }
}
