package org.mobedo;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairSplitter
{
    public AbstractMap.SimpleEntry<List<Integer>, List<Integer>> splitPair(List<AbstractMap.SimpleEntry<Integer, Integer>> input)
    {
        List<Integer> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for (AbstractMap.SimpleEntry<Integer,Integer> pair : input)
        {
            keys.add(pair.getKey());
            values.add(pair.getValue());
        }
        return new AbstractMap.SimpleEntry<>(keys, values);
    }
}
