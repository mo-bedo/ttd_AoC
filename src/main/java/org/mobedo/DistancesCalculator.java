package org.mobedo;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class DistancesCalculator
{
    public List<Integer> Calculate(AbstractMap.SimpleEntry<List<Integer>,List<Integer>> input)
    {
        List<Integer> list1 = input.getKey();
        List<Integer> list2 = input.getValue();
        List<Integer> distances = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            distances.add(Math.abs(list1.get(i) - list2.get(i)));
        }

        return distances;
    }
}
