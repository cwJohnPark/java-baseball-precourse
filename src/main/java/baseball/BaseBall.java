package baseball;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class BaseBall {

    private final int number;
    private final int position;

    public BaseBall(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public Hint hit(List<BaseBall> playerBalls) {
        return hit(new ArrayDeque<>(playerBalls));
    }

    private Hint hit(Deque<BaseBall> playerBalls) {
        if (playerBalls.isEmpty()) {
            return Hint.NOTHING;
        }
        BaseBall playerBall = playerBalls.poll();
        if (!isSameNumber(playerBall)) {
            return hit(playerBalls);
        }
        return hit(playerBall);
    }

    public Hint hit(BaseBall otherBall) {
        if (isSameNumber(otherBall) && isSamePosition(otherBall)) {
            return Hint.STRIKE;
        }

        if (isSameNumber(otherBall) && !isSamePosition(otherBall)) {
            return Hint.BALL;
        }

        return Hint.NOTHING;
    }

    private boolean isSamePosition(BaseBall other) {
        return position == other.position;
    }

    private boolean isSameNumber(BaseBall other) {
        return number == other.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBall otherBall = (BaseBall) o;

        return isSamePosition(otherBall) && isSameNumber(otherBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "BaseBall{" +
                "number=" + number +
                ", position=" + position +
                '}';
    }
}
