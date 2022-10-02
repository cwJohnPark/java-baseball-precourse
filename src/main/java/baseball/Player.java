package baseball;

public class Player {

    private final ComputerPlayer computerPlayer;

    public Player(ComputerPlayer computerPlayer) {
        this.computerPlayer = computerPlayer;
    }

    public HitResult hit(BaseBalls baseBalls) {
        Hints hints = computerPlayer.hit(baseBalls);
        return HitResult.create(hints);
    }
}
