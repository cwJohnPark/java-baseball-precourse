package baseball;

public enum Hint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    final String text;

    Hint(String text) {
        this.text = text;
    }
}
