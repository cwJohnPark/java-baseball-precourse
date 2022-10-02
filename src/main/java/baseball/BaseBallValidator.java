package baseball;

import baseball.utils.NumberUtils;

import static baseball.BaseBallConstants.*;
import static java.lang.String.format;

public class BaseBallValidator {

    public static void isValidBaseBallInput(String input) {
        if (!NumberUtils.isInteger(input)) {
            throw new IllegalArgumentException(format("'%s'은 숫자가 아닙니다", input));
        }

        int inputNumber = Integer.parseInt(input);

        if (!NumberUtils.isNumberDigitsOf(inputNumber, BASEBALL_COUNT, BASEBALL_MIN, BASEBALL_MAX)) {
            throw new IllegalArgumentException(format("'%s'는 유효한 범위의 숫자가 아닙니다", input));
        }

        if (!NumberUtils.isUniqueNumber(inputNumber)) {
            throw new IllegalArgumentException(format("'%s'는 중복 숫자가 있습니다.", input));
        }
    }
}
