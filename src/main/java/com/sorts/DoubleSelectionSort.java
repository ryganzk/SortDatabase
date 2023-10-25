package com.sorts;

import com.RandomList;

import java.util.List;

public class DoubleSelectionSort {
    public static void DoubleSelectionSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        int drillCnt = 1;
        System.out.println("---------------------------------");
        System.out.println("DOUBLE SELECTION SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        int n = randomList.size() - 1;
        for (int i = 0; i <= n; ++i) {
            int minIndex = i;
            int maxIndex = n;
            for (int j = i; j <= n; ++j) {
                int num = randomList.get(j);
                if (num < randomList.get(minIndex))
                    minIndex = j;

                if (num > randomList.get(maxIndex))
                    maxIndex = j;
            }

            int temp = randomList.get(i);
            randomList.set(i, randomList.get(minIndex));
            randomList.set(minIndex, temp);
            temp = randomList.get(n);
            randomList.set(n, randomList.get(maxIndex));
            randomList.set(maxIndex, temp);

            if (drill) {
                System.out.println("ITERATION " + drillCnt + ": " + randomList);
                ++drillCnt;
            }
            --n;
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
