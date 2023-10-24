package com.sorts;

import com.RandomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {
    public static void CountingSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        System.out.println("---------------------------------");
        System.out.println("COUNTING SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        int max = Collections.max(randomList);
        int[] countArr = new int[max + 1];

        for (int num : randomList)
            countArr[num] += 1;

        List<Integer> sortedList = new ArrayList<>();

        if(drill) {
            List<Integer> countList = new ArrayList<>();
            for (int num : countArr) {
                countList.add(num);
            }

            System.out.println("COUNT LIST: " + countList);
        }

        for (int i = 0; i < countArr.length; ++i) {
            while (countArr[i] > 0) {
                sortedList.add(i);
                --countArr[i];
            }
        }

        System.out.println("SORTED LIST: " + sortedList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(n+k)");
        System.out.println("TIME COMPLEXITY (AVG): O(n+k)");
        System.out.println("TIME COMPLEXITY (WORST): O(n+k)");
        System.out.println("SPACE COMPLEXITY: O(max)");
        System.out.println("STABLE: YES");
        System.out.println("---------------------------------");
    }
}
