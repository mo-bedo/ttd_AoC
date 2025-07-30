package org.mobedo;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SorterTest
{

    @Test
    void Sorter_emptyList_returnsEmptyLists()
    {
        //Arrange
        AbstractMap.SimpleEntry<List<Integer>,List<Integer>> input = new AbstractMap.SimpleEntry<List<Integer>,List<Integer>>(
                new ArrayList<>(),new ArrayList<>()
        );
        ListsSorter sut = new ListsSorter();

        //Act
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> result = sut.sort(input);

        //Assert
        assertTrue(result.getKey().isEmpty());
        assertTrue(result.getValue().isEmpty());

    }
}
