package com.sorts;

import com.RandomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSort {
    public static void RadixSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        System.out.println("---------------------------------");
        System.out.println("RADIX SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        int max = Collections.max(randomList);

        for (int place = 1; max / place > 0; place *= 10)
            randomList = RadixHelper(randomList, place, drill);

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(n+k)");
        System.out.println("TIME COMPLEXITY (AVG): O(n+k)");
        System.out.println("TIME COMPLEXITY (WORST): O(n+k)");
        System.out.println("SPACE COMPLEXITY: O(max)");
        System.out.println("STABLE: YES");
        System.out.println("---------------------------------");
    }

    static List<Integer> RadixHelper(List<Integer> numberList, int place, boolean drill) {
        int max = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            if (numberList.get(i) > max)
                max = numberList.get(i);
        }
        int[] countArr = new int[max + 1];

        for (int i = 0; i < numberList.size(); i++)
            countArr[(numberList.get(i) / place) % 10]++;

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }

        if(drill) {
            List<Integer> countList = new ArrayList<>();
            for (int num : countArr) {
                countList.add(num);
            }

            System.out.println("COUNT LIST: " + countList);
        }

        List<Integer> output = new ArrayList<>(Collections.nCopies(numberList.size(), 0));
        for (int i = numberList.size() - 1; i >= 0; i--) {
            int num = numberList.get(i);
            int index = (num / place) % 10;
            output.set(countArr[index] - 1, num);
            countArr[index]--;
        }

        if (drill)
            System.out.println("CURR LIST: " + output);
        return output;
    }
}
