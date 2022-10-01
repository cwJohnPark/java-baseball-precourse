package baseball;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class BaseBalls {

    private final List<BaseBall> baseBalls;

    public BaseBalls(BaseBall ...baseBalls) {
        this.baseBalls = Lists.newArrayList(baseBalls);
    }

    public BaseBalls(List<BaseBall> baseBalls) {
        this.baseBalls = baseBalls;
    }

    public static BaseBalls createBaseBalls(List<Integer> ballNumbers) {
        List<BaseBall> baseBalls = new ArrayList<>();
        for (int i = 0; i < ballNumbers.size(); i++) {
            baseBalls.add(new BaseBall(ballNumbers.get(i), i));
        }
        return new BaseBalls(baseBalls);
    }

    public Hints hit(BaseBalls playerBalls) {
        return hit(playerBalls.baseBalls);
    }

    private Hints hit(List<BaseBall> playerBalls) {
        Hints hints = Hints.createEmpty();

        for (BaseBall playerBall : playerBalls) {
            hints.add(hit(playerBall));
        }

        return hints;
    }

    private Hints hit(BaseBall playerBall) {
        Hints hints = Hints.createEmpty();
        for (BaseBall baseBall : baseBalls) {
            Hint hit = baseBall.hit(playerBall);
            hints.add(hit);
        }

        return hints;
    }

    @Override
    public String toString() {
        return "BaseBalls{" +
                "baseBalls=" + baseBalls +
                '}';
    }

    public boolean isSizeOf(int size) {
        return baseBalls.size() == size;
    }
}
