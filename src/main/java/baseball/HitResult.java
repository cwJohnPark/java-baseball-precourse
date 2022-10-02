package baseball;

public class HitResult {

    private final String resultText;

    private HitResult(String resultText) {
        this.resultText = resultText;
    }

    public static HitResult create(Hints hints) {
        if (hints.isNothing()) {
            return new HitResult(Hint.NOTHING.text);
        }

        String resultText = getHintText(hints, Hint.BALL) + getHintText(hints, Hint.STRIKE);

        return new HitResult(resultText);
    }

    private static String getHintText(Hints hints, Hint hint) {
        int count = hints.getCount(hint);
        return count > 0 ? count + hint.text : "";
    }

    public String getResultText() {
        return resultText;
    }
}
