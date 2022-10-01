package baseball;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hints {

    private final List<Hint> hints;

    public Hints(Hint... hints) {
        this.hints = Lists.newArrayList(hints);
    }

    public Hints(List<Hint> hints) {
        this.hints = hints;
    }

    public static Hints createEmpty() {
        return new Hints(new ArrayList<>());
    }

    public void add(Hints appendHints) {
        for (Hint hint : appendHints.hints) {
            add(hint);
        }
    }

    public void add(Hint hint) {
        if (hint == Hint.NOTHING) {
            return;
        }
        hints.add(hint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hints otherHints = (Hints) o;
        if (isNothing(this) && isNothing(otherHints)) {
            return true;
        }
        return containsAllElementsInAnyOrder(otherHints);
    }

    private boolean isNothing(Hints hints) {
        return isNothing(hints.hints);
    }

    private boolean isNothing(List<Hint> hints) {
        return hints.isEmpty() || (hints.size() == 1 && hints.contains(Hint.NOTHING));
    }

    private boolean containsAllElementsInAnyOrder(Hints other) {
        List<Hint> otherHints = other.hints;
        if (hints.size() != otherHints.size()) {
            return false;
        }
        return this.hints.containsAll(otherHints) && otherHints.containsAll(this.hints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hints);
    }
}
