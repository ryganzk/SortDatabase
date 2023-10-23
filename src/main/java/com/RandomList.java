package com;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class RandomList {
    public static List<Integer> CreateRandomList(int length) {
        List<Integer> output = new ArrayList<>();

        for (int i = 1; i <= length; ++i) {
            output.add(i);
        }

        Collections.shuffle(output);
        return output;
    }
}
