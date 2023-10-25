package com.sorts;

import com.RandomList;

import java.util.List;

public class InsertionSort {
    public static void InsertionSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        int drillCnt = 1;
        System.out.println("---------------------------------");
        System.out.println("INSERTION SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        for (int i = 1; i < randomList.size(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (randomList.get(j) > randomList.get(j + 1)) {
                    int temp = randomList.get(j);
                    randomList.set(j, randomList.get(j + 1));
                    randomList.set(j + 1, temp);
                }
            }

            if (drill) {
                System.out.println("ITERATION " + drillCnt + ": " + randomList);
                ++drillCnt;
            }
        }

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(n)");
        System.out.println("TIME COMPLEXITY (AVG): O(n²)");
        System.out.println("TIME COMPLEXITY (WORST): O(n²)");
        System.out.println("SPACE COMPLEXITY: O(1)");
        System.out.println("STABLE: YES");
        System.out.println("---------------------------------");
    }
}

