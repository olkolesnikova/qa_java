import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTests {

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "5, 5"
    })
    void getKittensWithParamReturnsExpected(int input, int expected) {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}
