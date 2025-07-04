package org.mobedo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import java.util.AbstractMap;
import java.util.List;
import java.util.stream.Stream;

class ParserTest
{
    @Test
    void ParseTest()
    {
        // Arrange
        String[] input = { };
        Parser sut = new Parser();

        // Act
        List<AbstractMap.SimpleEntry<Integer, Integer>> result = sut.parse(input);

        // Assert
        assertEquals(result.size(), 0);
    }
    @Test
    void ParseTest1()
    {
        // Arrange
        String[] input = { "4   3" };
        Parser sut = new Parser();

        // Act
        List<AbstractMap.SimpleEntry<Integer, Integer>> result = sut.parse(input);

        // Assert
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getKey(), 4);
        assertEquals(result.get(0).getValue(), 3);
    }

//        String[] input = { "3   4", "4   3", "2   5" };

    @ParameterizedTest
    @MethodSource("InputSplitTest")
    void SplitTest(String input, AbstractMap.SimpleEntry<Integer, Integer> expected)
    {
        // Arrange
        Parser sut = new Parser();

        // Act
        AbstractMap.SimpleEntry<Integer, Integer> result = sut.split(input);

        // Assert
        assertEquals(expected.getKey(), result.getKey());
        assertEquals(expected.getValue(), result.getValue());
    }

    private static Stream<Arguments> InputSplitTest() {
        return Stream.of(
                Arguments.of( "4   3",  new AbstractMap.SimpleEntry<Integer, Integer>(4, 3)),
                Arguments.of( "3   4",  new AbstractMap.SimpleEntry<Integer, Integer>(3, 4))
        );
    }
}