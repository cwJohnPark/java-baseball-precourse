package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.Prompt.*;

public class BaseBallGame {

    private final Player player;
    private final Scanner scanner;

    public BaseBallGame(Player player) {
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    public GameControlCode play() {
        HitResult hitResult;
        do {
            print(INPUT);
            List<Integer> inputNumbers = getBaseBallsInput();
            BaseBalls baseBalls = BaseBalls.createBaseBalls(inputNumbers);
            hitResult = player.hit(baseBalls);
            println(hitResult.getResultText());
        } while (!isSuccess(hitResult));

        printSuccessPrompt();
        return getControlCode();
    }

    private void printSuccessPrompt() {
        println(SUCCESS);
        print(TERMINATE);
        println(CONTINUE);
    }

    private GameControlCode getControlCode() {
        String input = scanner.nextLine();
        return GameControlCode.of(input);
    }

    public boolean isSuccess(HitResult hitResult) {
        return hitResult.isSuccess();
    }

    private List<Integer> getBaseBallsInput() {
        String input = scanner.nextLine();
        return toNumbers(input);
    }

    private List<Integer> toNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            numbers.add(Character.getNumericValue(digit));
        }

        return numbers;
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
