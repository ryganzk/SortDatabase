package com.sorts;

import com.RandomList;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void MergeSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        int drillCnt = 1;
        System.out.println("---------------------------------");
        System.out.println("MERGE SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        randomList = MergeHelper(randomList, drill);

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(nlogn)");
        System.out.println("TIME COMPLEXITY (AVG): O(nlogn)");
        System.out.println("TIME COMPLEXITY (WORST): O(nlogn)");
        System.out.println("SPACE COMPLEXITY: O(n)");
        System.out.println("STABLE: YES");
        System.out.println("---------------------------------");
    }

    static List<Integer> MergeHelper(List<Integer> numberList, boolean drill) {
        if (numberList.size() == 1) {
            return numberList;
        } else {
            int midpoint = numberList.size() / 2;
            List<Integer> firstList = MergeHelper(numberList.subList(0, midpoint), drill);
            List<Integer> lastList = MergeHelper(numberList.subList(midpoint, numberList.size()), drill);

            if (drill) {
                System.out.println("FIRST LIST: " + firstList);
                System.out.println("LAST LIST: " + lastList);
            }
            List<Integer> output = new ArrayList<Integer>();

            int a = 0;
            int b = 0;
            while (a < firstList.size() && b < lastList.size()) {
                if (firstList.get(a) <= lastList.get(b)) {
                    output.add(firstList.get(a));
                    ++a;
                } else {
                    output.add(lastList.get(b));
                    ++b;
                }
            }

            if (a >= firstList.size()) {
                for (int i = b; i < lastList.size(); ++i)
                    output.add(lastList.get(i));
            } else {
                for (int i = a; i < firstList.size(); ++i)
                    output.add(firstList.get(i));
            }

            if (drill)
                System.out.println("CURR LIST: " + output + "\n");
            return output;
        }
    }
}
