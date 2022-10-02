package baseball;

import static java.lang.String.format;

public class HitResult {

    private final String resultText;
    private final boolean isSuccess;

    private HitResult(String resultText, boolean isSuccess) {
        this.resultText = resultText;
        this.isSuccess = isSuccess;
    }

    public static HitResult create(Hints hints) {
        if (hints.isNothing()) {
            return new HitResult(Hint.NOTHING.text, false);
        }

        String resultText =
                format("%s %s", getHintText(hints, Hint.BALL), getHintText(hints, Hint.STRIKE))
                .trim();

        return new HitResult(resultText, isSuccess(hints));
    }

    private static boolean isSuccess(Hints hints) {
        return hints.getCount(Hint.STRIKE) == 3;
    }

    private static String getHintText(Hints hints, Hint hint) {
        int count = hints.getCount(hint);
        return count > 0 ? count + hint.text : "";
    }

    public String getResultText() {
        return resultText;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
