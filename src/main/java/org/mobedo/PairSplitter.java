package org.mobedo;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class PairSplitter
{
    public AbstractMap.SimpleEntry<List<Integer>, List<Integer>> splitPair(List<AbstractMap.SimpleEntry<Integer, Integer>> input)
    {
        return new AbstractMap.SimpleEntry<>(new ArrayList<>(), new ArrayList<>());

    }
}
