package baseball;

import java.util.Scanner;

import static java.lang.String.format;

public class InputController {

    public final Scanner scanner;

    public InputController(Scanner scanner) {
        this.scanner = scanner;
    }

    public <T> T input(Validator validator, Transformer<T> transformer) {
        String input = scanner.nextLine();
        validate(input, validator);
        return transformer.transform(input);
    }

    private void validate(String input, Validator validator) {
        try {
            validator.validate(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(format("'%s' 는 올바른 입력이 아닙니다.", input), e);
        }
    }

    interface Validator {
        void validate(String input);
    }

    interface Transformer<T> {
        T transform(String input);
    }
}
