package com.sorts;

import com.RandomList;

import java.util.List;

public class ShellSort {
    public static void ShellSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        System.out.println("---------------------------------");
        System.out.println("SHELL SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        for (int interval = randomList.size() / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < randomList.size(); i += 1) {
                int temp = randomList.get(i);
                int j;
                for (j = i; j >= interval && randomList.get(j - interval) > temp; j -= interval) {
                    randomList.set(j, randomList.get(j - interval));
                }
                randomList.set(j, temp);
            }

            if (drill)
                System.out.println("SHELL AT INTERVAL " + interval + ": " + randomList);
        }

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(nlogn)");
        System.out.println("TIME COMPLEXITY (AVG): O(n²)");
        System.out.println("TIME COMPLEXITY (WORST): O(nlogn)");
        System.out.println("SPACE COMPLEXITY: O(1)");
        System.out.println("STABLE: NO");
        System.out.println("---------------------------------");
    }
}
