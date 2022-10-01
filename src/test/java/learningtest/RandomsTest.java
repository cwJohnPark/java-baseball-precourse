package learningtest;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RandomsTest {

    @ParameterizedTest
    @CsvSource(value ={"1,9,3", "2, 5, 4"})
    void testPickUniqueNumbersInRange(int min, int max, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, count);

        assertThat(numbers.size()).isEqualTo(count);

        for (int i = min; i <= max; i++) {
            numbers.remove(Integer.valueOf(i));
            assertThat(numbers).doesNotContain(i);
        }
        assertThat(numbers).isEmpty();
    }

}
