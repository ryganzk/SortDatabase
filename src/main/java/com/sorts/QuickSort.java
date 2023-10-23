package com.sorts;

import com.RandomList;

import java.util.List;

public class QuickSort {
    public static void QuickSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        int drillCnt = 1;
        System.out.println("---------------------------------");
        System.out.println("QUICK SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        randomList = QuickHelper(randomList, drill);

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(nlogn)");
        System.out.println("TIME COMPLEXITY (AVG): O(nlogn)");
        System.out.println("TIME COMPLEXITY (WORST): O(n²)");
        System.out.println("SPACE COMPLEXITY: O(logn)");
        System.out.println("STABLE: NO");
        System.out.println("---------------------------------");
    }

    static List<Integer> QuickHelper(List<Integer> numberList, boolean drill) {
        if (numberList.size() <= 1)
            return numberList;
        else {
            int l = 0;
            int r = numberList.size() - 1;
            int pivotVal = numberList.get(numberList.size() - 1);

            while (l < r) {
                if (numberList.get(l) > pivotVal) {
                    boolean found = false;
                    for (int i = l + 1; i < r; ++i) {
                        if (numberList.get(i) < pivotVal) {
                            int temp = numberList.get(i);
                            numberList.set(i, numberList.get(l));
                            numberList.set(l, temp);
                            found = true;
                        }
                    }
                    if (!found)
                        break;
                }
                ++l;
            }

            int temp = numberList.get(l);
            numberList.set(l, pivotVal);
            numberList.set(numberList.size() - 1, temp);

            if(drill) {
                System.out.println("CURR LIST: " + numberList);
                System.out.println("LEFT SPLIT: " + numberList.subList(0, l));
                System.out.println("RIGHT SPLIT: " + numberList.subList(l + 1, numberList.size()) + "\n");
            }

            QuickHelper(numberList.subList(0, l), drill);
            QuickHelper(numberList.subList(l + 1, numberList.size()), drill);

            return numberList;
        }
    }
}
