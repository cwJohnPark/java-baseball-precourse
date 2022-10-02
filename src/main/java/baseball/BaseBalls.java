package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBalls {

    private final List<BaseBall> baseBalls;

    public BaseBalls(List<BaseBall> baseBalls) {
        this.baseBalls = baseBalls;
    }

    public static BaseBalls createBaseBalls(int ...ballNumbers) {
        final List<Integer> balls = new ArrayList<>();
        for (int ballNumber : ballNumbers) {
            balls.add(ballNumber);
        }

        return createBaseBalls(balls);
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

        if (baseBalls.size() != playerBalls.size()) {
            throw new IllegalArgumentException("PlayerBall 개수가 다릅니다.");
        }

        for (BaseBall baseBall: baseBalls) {
            hints.add(baseBall.hit(playerBalls));
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
