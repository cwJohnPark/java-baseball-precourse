package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Hints {

    private final Map<Hint, Integer> hints;

    private Hints() {
        this.hints = new HashMap<>();
    }

    public static Hints createEmpty() {
        return new Hints();
    }

    public void add(Hint hint) {
        if (hint == Hint.NOTHING) {
            return;
        }
        hints.merge(hint, 1, Integer::sum);
    }

    public void addAll(List<Hint> addedHints) {
        for (Hint addedHint : addedHints) {
            add(addedHint);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hints other = (Hints) o;
        if (isNothing() && other.isNothing()) {
            return true;
        }
        return Objects.equals(hints, other.hints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hints);
    }

    public boolean isNothing() {
        return isNothing(hints);
    }

    public boolean isNothing(Map<Hint, Integer> hints) {
        return hints.isEmpty() ||
                (hints.keySet().size() == 1 && hints.containsKey(Hint.NOTHING));
    }


    public int getCount(Hint hint) {
        return contains(hint) ? hints.get(hint) : 0;
    }

    private boolean contains(Hint hint) {
        return hints.containsKey(hint);
    }
}
