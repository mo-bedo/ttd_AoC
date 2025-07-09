package org.mobedo;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PairSplitterTest
{
    @Test
    void PairSplitterReturnEmptyListGivenEmptyInput()
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

    @Test
    void PairSplitterTest()
    {
        // Arrange
        List<AbstractMap.SimpleEntry<Integer, Integer>> input = new ArrayList<>(List.of(new AbstractMap.SimpleEntry<>(4, 3)));
        PairSplitter sut = new PairSplitter();

        // Act
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> result = sut.splitPair(input);

        // Assert
        assertEquals(result.getKey(), List.of(4));
        assertEquals(result.getValue(), List.of(3));
    }
}
