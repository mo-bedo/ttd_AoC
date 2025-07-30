package org.mobedo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PairSplitterTest
{
    @Test
    void PairSplitter_emptyInput_returnsEmptyListTest()
    {
        // Arrange
        List<AbstractMap.SimpleEntry<Integer, Integer>> input = new ArrayList<>();
        PairSplitter sut = new PairSplitter();

        // Act
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> result = sut.splitPair(input);

        // Assert
        assertTrue(result.getKey().isEmpty());
        assertTrue(result.getValue().isEmpty());
    }

    private static Stream<Arguments> InputLinesPairSplitter() {
        return Stream.of(
                Arguments.of(List.of(new AbstractMap.SimpleEntry<>(4, 3)), new AbstractMap.SimpleEntry<>(List.of(4), List.of(3))),
                Arguments.of(List.of(new AbstractMap.SimpleEntry<>(14697, 55843)), new AbstractMap.SimpleEntry<>(List.of(14697), List.of(55843))),
                Arguments.of(List.of(new AbstractMap.SimpleEntry<>(6, 4)), new AbstractMap.SimpleEntry<>(List.of(6), List.of(4))),
                Arguments.of(
                        List.of
                                (
                                    new AbstractMap.SimpleEntry<>(4, 3),
                                    new AbstractMap.SimpleEntry<>(6, 4)
                                ),
                        new AbstractMap.SimpleEntry<>(List.of(4,6), List.of(3,4)))
        );
    }

    @ParameterizedTest
    @MethodSource ("InputLinesPairSplitter")
    void PairSplitter_multiplePairs_returnsCorrectlySplitListsTest (List<AbstractMap.SimpleEntry<Integer, Integer>> input,
                                                                    AbstractMap.SimpleEntry<List<Integer>, List<Integer>> expected)
    {
        // Arrange
        PairSplitter sut = new PairSplitter();

        // Act
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> result = sut.splitPair(input);

        // Assert
        assertEquals(expected, result);
    }


}
