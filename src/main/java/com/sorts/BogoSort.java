package com.sorts;

import com.RandomList;

import java.util.Collections;
import java.util.List;

public class BogoSort {
    public static void BogoSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        System.out.println("---------------------------------");
        System.out.println("BOGO SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        boolean checking = true;
        while (checking) {
            checking = false;
            for (int i = 0; i < randomList.size() - 1; ++i) {
                if (randomList.get(i) > randomList.get(i + 1)) {
                    checking = true;
                    Collections.shuffle(randomList);
                    break;
                }
            }

            if (drill)
                System.out.println("NEWLY SHUFFLED LIST: " + randomList);
        }

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(n)");
        System.out.println("TIME COMPLEXITY (AVG): O(n*n!)");
        System.out.println("TIME COMPLEXITY (WORST): O(∞)");
        System.out.println("SPACE COMPLEXITY: O(1)");
        System.out.println("STABLE: NO");
        System.out.println("---------------------------------");
    }
}
