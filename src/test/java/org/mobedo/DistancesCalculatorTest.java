package org.mobedo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistancesCalculatorTest
{
    @ParameterizedTest
    @MethodSource("InputDistancesTest")
    void DistancesCalculator_multiLists_returnsList(AbstractMap.SimpleEntry<List<Integer>,List<Integer>> input, List<Integer> expected)
    {
        // Arrange
        DistancesCalculator sut = new DistancesCalculator();

        // Act
        List<Integer> actual = sut.Calculate(input);

        // Assert
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> InputDistancesTest() {
        return Stream.of(
                Arguments.of( new AbstractMap.SimpleEntry<>(List.of(),  List.of()), List.of()),
                Arguments.of( new AbstractMap.SimpleEntry<>(List.of(2, 1),  List.of(4, 3)), List.of(2, 2)),
                Arguments.of( new AbstractMap.SimpleEntry<>(List.of(9, 1),  List.of(4, 3)), List.of(5, 2))
        );
    }
}
