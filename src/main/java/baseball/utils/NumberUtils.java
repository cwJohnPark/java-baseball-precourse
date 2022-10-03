package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.BaseBallConstants.BASEBALL_MAX;
import static baseball.BaseBallConstants.BASEBALL_MIN;

public class NumberUtils {

    public static boolean isIntegerInRange(String number, int startInclusive, int endInclusive) {
        if (!isInteger(number)) {
            return false;
        }
        return isIntegerInRange(Integer.parseInt(number), startInclusive, endInclusive);
    }

    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isIntegerInRange(int number, int startInclusive, int endInclusive) {
        return number >= startInclusive && number <= endInclusive;
    }

    public static boolean isUniqueNumber(int number) {
        return isUniqueNumber(number, new HashSet<>());
    }

    private static boolean isUniqueNumber(int number, Set<Integer> cache) {
        if (number == 0) {
            return true;
        }
        int firstDigit = number % 10;
        if (cache.contains(firstDigit)) {
            return false;
        }
        cache.add(firstDigit);
        return isUniqueNumber(number / 10, cache);
    }

    public static boolean isNumberDigitsOf(int number, int digit, int min, int max) {
        if (String.valueOf(number).length() != digit) {
            return false;
        }

        boolean isInRange = true;
        for (int i = 0; i < digit; i++) {
            isInRange &= isIntegerInRange(number % 10, min, max);
            number /= 10;
        }

        return isInRange;
    }


    public static List<Integer> toNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            numbers.add(Character.getNumericValue(digit));
        }

        return numbers;
    }

    public static List<Integer> getUniqueNumbers(int count) {
        return new ArrayList<>(getUniqueNumbers(count, new HashSet<>()));
    }

    private static Set<Integer> getUniqueNumbers(int count, Set<Integer> uniqueNumbers) {
        if (count == 0) {
            return Collections.emptySet();
        }

        int randomNumber = Randoms.pickNumberInRange(BASEBALL_MIN, BASEBALL_MAX);
        if (uniqueNumbers.contains(randomNumber)) {
            return getUniqueNumbers(count, uniqueNumbers);
        }
        uniqueNumbers.add(randomNumber);
        uniqueNumbers.addAll(getUniqueNumbers(count-1, uniqueNumbers));
        return uniqueNumbers;
    }
}
