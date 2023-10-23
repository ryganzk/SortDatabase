package com.sorts;

import com.RandomList;

import java.util.List;

public class SelectionSort {
    public static void SelectionSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        int drillCnt = 1;
        System.out.println("---------------------------------");
        System.out.println("SELECTION SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        for (int i = 0; i < randomList.size(); ++i) {
            int minIndex = i;
            for (int j = i + 1; j < randomList.size(); ++j) {
                if (randomList.get(j) < randomList.get(minIndex))
                    minIndex = j;
            }

            int temp = randomList.get(i);
            randomList.set(i, randomList.get(minIndex));
            randomList.set(minIndex, temp);

            if (drill) {
                System.out.println("ITERATION " + drillCnt + ": " + randomList);
                ++drillCnt;
            }
        }

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(n²)");
        System.out.println("TIME COMPLEXITY (AVG): O(n²)");
        System.out.println("TIME COMPLEXITY (WORST): O(n²)");
        System.out.println("SPACE COMPLEXITY: O(1)");
        System.out.println("STABLE: NO");
        System.out.println("---------------------------------");
    }
}
