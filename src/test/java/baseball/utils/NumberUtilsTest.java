package baseball.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {

    @ParameterizedTest
    @CsvSource({"1","2","3","4","5"})
    void testGetUniqueNumbers(int count) {
        List<Integer> uniqueNumbers = NumberUtils.getUniqueNumbers(count);

        assertThat(NumberUtils.isUniqueNumber(toInteger(uniqueNumbers))).isTrue();
    }

    private int toInteger(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
            result *= 10;
        }

        return result / 10;
    }
}