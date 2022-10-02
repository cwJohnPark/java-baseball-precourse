package baseball;

import baseball.utils.NumberUtils;

import java.util.List;

import static baseball.Prompt.*;
import static java.lang.String.format;

public class BaseBallGame {

    private final Player player;
    private final InputController inputController;

    public BaseBallGame(Player player, InputController inputController) {
        this.player = player;
        this.inputController = inputController;
    }

    public GameControlCode play() {
        HitResult hitResult;
        do {
            print(INPUT);
            List<Integer> inputNumbers = getBaseBallsInput();
            BaseBalls baseBalls = BaseBalls.createBaseBalls(inputNumbers);
            hitResult = player.hit(baseBalls);
            println(hitResult.getResultText());
        } while (!hitResult.isSuccess());

        printSuccessPrompt();
        return getControlCode();
    }

    private void printSuccessPrompt() {
        println(SUCCESS);
        print(TERMINATE);
        println(CONTINUE);
    }

    private GameControlCode getControlCode() {
        return inputController.input(
                this::validateGameControlCode,
                GameControlCode::of);
    }

    private void validateGameControlCode(String input) {
        if (!NumberUtils.isIntegerInRange(input,1, 2)) {
            throw new IllegalArgumentException(format("'%s'는 올바른 게임 제어 코드가 아닙니다", input));
        }
    }

    private List<Integer> getBaseBallsInput() {
        return inputController.input(
                BaseBallValidator::isValidBaseBallInput,
                NumberUtils::toNumbers);
    }

    private void println(String prompt) {
        System.out.println(prompt);
    }

    private void print(String inputPrompt) {
        System.out.print(inputPrompt);
    }

    public void resetComputerPlayer() {
        player.resetComputerPlayer();
    }
}
