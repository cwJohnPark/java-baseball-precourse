package baseball;

public enum GameControlCode {
    CONTINUE("1"),
    TERMINATE("2");

    private final String code;

    GameControlCode(String code) {
        this.code = code;
    }

    public static GameControlCode of(String code) {
        if (TERMINATE.code.equals(code)) {
            return TERMINATE;
        }
        return CONTINUE;
    }
}
