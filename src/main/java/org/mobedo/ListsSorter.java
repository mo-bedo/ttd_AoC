package org.mobedo;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListsSorter
{
    public AbstractMap.SimpleEntry<List<Integer>, List<Integer>> sort(AbstractMap.SimpleEntry<List<Integer>,List<Integer>> input)
    {
        List<Integer> sortedKeyList = new ArrayList<>(input.getKey());
        List<Integer> sortedValueList = new ArrayList<>(input.getValue());

        Collections.sort(sortedKeyList);
        Collections.sort(sortedValueList);

        return new AbstractMap.SimpleEntry<>(sortedKeyList, sortedValueList);
    }
}
