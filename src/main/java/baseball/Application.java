package baseball;

import java.util.Scanner;

public class Application {
    private static BaseBallGame baseBallGame;

    public static void main(String[] args) {
        baseBallGame = createBaseBallGame();
        play();
    }

    private static void play() {
        GameControlCode gameControlCode = baseBallGame.play();
        if (gameControlCode == GameControlCode.CONTINUE) {
            baseBallGame.resetComputerPlayer();
            play();
        }
    }

    private static BaseBallGame createBaseBallGame() {
        ComputerPlayer computerPlayer = new ComputerPlayer();
        computerPlayer.setRandomBaseBalls();
        Player player = new Player(computerPlayer);

        InputController inputController = new InputController(new Scanner(System.in));
        return new BaseBallGame(player, inputController);
    }
}
