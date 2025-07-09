package org.mobedo;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Parser
{

    public AbstractMap.SimpleEntry<Integer, Integer> split(String input)
    {
        String[] parts = input.split("\\s+"); // Splits by whitespace
        int first = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        return new AbstractMap.SimpleEntry<>(first, second);
    }

    public List<AbstractMap.SimpleEntry<Integer, Integer>> parse(String[] lines)
    {
        List<AbstractMap.SimpleEntry<Integer, Integer>> result = new ArrayList<>();

        for (String line : lines)
        {
            result.add(split(line));
        }
        return result;
    }

}