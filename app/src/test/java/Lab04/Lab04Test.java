/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Lab04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class Lab04Test {

    @ParameterizedTest
    @MethodSource("factorsOfNumber")
    void multiSum(int n, List<List<Integer>> expectedArr) {
        List<List<Integer>> realArr = Lab04.multiSum(n);
        assertEquals(expectedArr, realArr);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> factorsOfNumber() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(Arrays.asList(1, 3))),
                Arguments.of(6, Arrays.asList(Arrays.asList(1, 6), Arrays.asList(2, 3))),
                Arguments.of(15, Arrays.asList(Arrays.asList(1, 15), Arrays.asList(3, 5))),
                Arguments.of(17, Arrays.asList(Arrays.asList(1, 17))),
                Arguments.of(1, Arrays.asList(Arrays.asList(1))),
                Arguments.of(0, Arrays.asList(Arrays.asList(0))),
                Arguments.of(16, Arrays.asList(
                    Arrays.asList(1, 16),
                    Arrays.asList(2, 8),
                    Arrays.asList(2, 2, 4),
                    Arrays.asList(2, 2, 2, 2),
                    Arrays.asList(4, 4)
                    )),
                Arguments.of(12, Arrays.asList(
                    Arrays.asList(1, 12),
                    Arrays.asList(2, 6),
                    Arrays.asList(2, 2, 3),
                    Arrays.asList(3, 4)
                    )),
                Arguments.of(325, Arrays.asList(
                    Arrays.asList(1, 325),
                    Arrays.asList(5, 65),
                    Arrays.asList(5, 5, 13),
                    Arrays.asList(13, 25)
                    )),
                Arguments.of(487, Arrays.asList(
                    Arrays.asList(1, 487)
                    )),
                Arguments.of(6200, Arrays.asList(
                    Arrays.asList(1, 6200),
                    Arrays.asList(2, 3100),
                    Arrays.asList(2, 2, 1550),
                    Arrays.asList(2, 2, 2, 775),
                    Arrays.asList(2, 2, 2, 5, 155),
                    Arrays.asList(2, 2, 2, 5, 5, 31),
                    Arrays.asList(2, 2, 2, 25, 31),
                    Arrays.asList(2, 2, 5, 310),
                    Arrays.asList(2, 2, 5, 5, 62),
                    Arrays.asList(2, 2, 5, 10, 31),
                    Arrays.asList(2, 2, 10, 155),
                    Arrays.asList(2, 2, 25, 62),
                    Arrays.asList(2, 2, 31, 50),
                    Arrays.asList(2, 4, 775),
                    Arrays.asList(2, 4, 5, 155),
                    Arrays.asList(2, 4, 5, 5, 31),
                    Arrays.asList(2, 4, 25, 31),
                    Arrays.asList(2, 5, 620),
                    Arrays.asList(2, 5, 5, 124),
                    Arrays.asList(2, 5, 10, 62),
                    Arrays.asList(2, 5, 20, 31),
                    Arrays.asList(2, 10, 310),
                    Arrays.asList(2, 10, 10, 31),
                    Arrays.asList(2, 20, 155),
                    Arrays.asList(2, 25, 124),
                    Arrays.asList(2, 31, 100),
                    Arrays.asList(2, 50, 62),
                    Arrays.asList(4, 1550),
                    Arrays.asList(4, 5, 310),
                    Arrays.asList(4, 5, 5, 62),
                    Arrays.asList(4, 5, 10, 31),
                    Arrays.asList(4, 10, 155),
                    Arrays.asList(4, 25, 62),
                    Arrays.asList(4, 31, 50),
                    Arrays.asList(5, 1240),
                    Arrays.asList(5, 5, 248),
                    Arrays.asList(5, 5, 8, 31),
                    Arrays.asList(5, 8, 155),
                    Arrays.asList(5, 10, 124),
                    Arrays.asList(5, 20, 62),
                    Arrays.asList(5, 31, 40),
                    Arrays.asList(8, 775),
                    Arrays.asList(8, 25, 31),
                    Arrays.asList(10, 620),
                    Arrays.asList(10, 10, 62),
                    Arrays.asList(10, 20, 31),
                    Arrays.asList(20, 310),
                    Arrays.asList(25, 248),
                    Arrays.asList(31, 200),
                    Arrays.asList(40, 155),
                    Arrays.asList(50, 124),
                    Arrays.asList(62, 100)
                )));
    }

    @Test
    public void testIncorrectInput() {
        Throwable exception = assertThrows(NumberFormatException.class, () -> Lab04.multiSum(-1));
    }

    @Test
    public void testIncorrectInputWithMessage() {
        Throwable exception = assertThrows(NumberFormatException.class, () -> Lab04.multiSum(-1));
        assertTrue(exception.getMessage().contentEquals("Try again with a positive integer."));
    }

    @Test
    public void testIncorrectMaxInput() {
        Throwable exception = assertThrows(NumberFormatException.class, () -> Lab04.multiSum(65536));
    }

    @Test
    public void testIncorrectMaxInputWithMessage() {
        Throwable exception = assertThrows(NumberFormatException.class, () -> Lab04.multiSum(65536));
        assertTrue(exception.getMessage().contentEquals("Try again with any integer less than 65536"));
    }
}
