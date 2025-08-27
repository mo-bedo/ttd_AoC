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

public class SorterTest
{
    @ParameterizedTest
    @MethodSource("InputSorterTest")
    void Sorter_multiEntryList_returnsCorrectSortedLists(AbstractMap.SimpleEntry<List<Integer>,List<Integer>> input, AbstractMap.SimpleEntry<List<Integer>,List<Integer>> expected)
    {
        //Arrange
        ListsSorter sut = new ListsSorter();

        //Act
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> result = sut.sort(input);

        //Assert
        assertEquals(expected.getKey(), result.getKey());
        assertEquals(expected.getValue(), result.getValue());

    }

    private static Stream<Arguments> InputSorterTest() {
        return Stream.of(
                Arguments.of( new AbstractMap.SimpleEntry<>(List.of(),  List.of()), new AbstractMap.SimpleEntry<>(List.of(), List.of())),
                Arguments.of( new AbstractMap.SimpleEntry<>(List.of(1),  List.of(2)), new AbstractMap.SimpleEntry<>(List.of(1), List.of(2))),
                Arguments.of( new AbstractMap.SimpleEntry<>(List.of(1, 2),  List.of(3, 4)), new AbstractMap.SimpleEntry<>(List.of(1,2), List.of(3,4))),
                Arguments.of( new AbstractMap.SimpleEntry<>(List.of(2, 1),  List.of(4, 3)), new AbstractMap.SimpleEntry<>(List.of(1,2), List.of(3,4))));
    }

}
