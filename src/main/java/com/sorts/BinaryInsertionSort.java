package com.sorts;

import com.RandomList;

import java.util.List;

public class BinaryInsertionSort {
    public static void BinaryInsertionSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        int drillCnt = 1;
        System.out.println("---------------------------------");
        System.out.println("BINARY INSERTION SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        for (int i = 1; i < randomList.size(); ++i) {
            int key = randomList.get(i);
            int l = 0;
            int r = i - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (key < randomList.get(mid)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            for (int j = i - 1; j >= l; j--) {
                randomList.set(j + 1, randomList.get(j));
            }

            randomList.set(l, key);

            if (drill) {
                System.out.println("ITERATION " + drillCnt + ": " + randomList);
                ++drillCnt;
            }
        }

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(nlogn)");
        System.out.println("TIME COMPLEXITY (AVG): O(n²)");
        System.out.println("TIME COMPLEXITY (WORST): O(n²)");
        System.out.println("SPACE COMPLEXITY: O(1)");
        System.out.println("STABLE: YES");
        System.out.println("---------------------------------");
    }
}
