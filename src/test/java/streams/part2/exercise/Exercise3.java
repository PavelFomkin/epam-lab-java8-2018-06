package streams.part2.exercise;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Exercise3 {

    @Test
    public void createLimitedStringWithOddNumbersSeparatedBySpaces() {
        int countNumbers = 10;

        String result = Stream.iterate(1, n -> n + 2)
                .limit(10)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        assertEquals("1 3 5 7 9 11 13 15 17 19", result);
    }

    @Test
    public void extractEvenNumberedCharactersToNewString() {
        String source = "abcdefghijklm";

        String result = source.chars()
                .mapToObj(x -> (char) x)
                .filter(x -> (x & 1) == 1)
                .reduce("", (start,next) -> start + next, String::concat);

        assertEquals("acegikm", result);
    }
}
