package org.mobedo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ParserTest
{
    @Test
    void ParseReturnEmptyListGivenEmptyInput()
    {
        // Arrange
        String[] input = { };
        Parser sut = new Parser();

        // Act
        List<AbstractMap.SimpleEntry<Integer, Integer>> result = sut.parse(input);

        // Assert
        assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("InputParseTest")
    void ParseTest(String[] input, List<AbstractMap.SimpleEntry<Integer, Integer>> expected)
    {
        // Arrange
        Parser sut = new Parser();

        // Act
        List<AbstractMap.SimpleEntry<Integer, Integer>> result = sut.parse(input);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> InputParseTest() {
        return Stream.of(
                Arguments.of(new String[]{"4   3"}, new ArrayList<>(List.of(new AbstractMap.SimpleEntry<>(4, 3)))),
                Arguments.of(new String[]{"3   4"}, new ArrayList<>(List.of(new AbstractMap.SimpleEntry<>(3, 4)))),
                Arguments.of(new String[]{"3   4", "4   3"}, new ArrayList<>(List.of(new AbstractMap.SimpleEntry<>(3, 4), new AbstractMap.SimpleEntry<>(4, 3))))
        );
    }

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