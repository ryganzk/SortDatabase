package com.sorts;

import com.RandomList;

import java.util.List;

public class HeapSort {
    public static void HeapSortExample (int length, boolean drill) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        System.out.println("---------------------------------");
        System.out.println("HEAP SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        // Build max heap
        for (int i = randomList.size() / 2 - 1; i >= 0; --i) {
            Heapify(randomList, randomList.size(), i, drill);
        }

        if(drill) {
            System.out.println("MAX HEAP: " + randomList);
        }

        for (int i = randomList.size() - 1; i >= 0; --i) {
            int temp = randomList.get(0);
            randomList.set(0, randomList.get(i));
            randomList.set(i, temp);

            Heapify(randomList, i, 0, drill);
        }

        System.out.println("SORTED LIST: " + randomList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(nlogn)");
        System.out.println("TIME COMPLEXITY (AVG): O(nlogn)");
        System.out.println("TIME COMPLEXITY (WORST): O(nlogn)");
        System.out.println("SPACE COMPLEXITY: O(1)");
        System.out.println("STABLE: NO");
        System.out.println("---------------------------------");
    }

    static void Heapify(List<Integer> numberList, int n, int index, boolean drill) {
        int largest = index;
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;

        // Determines the new maxheap val from the root and left/right children
        if(lChild < n && numberList.get(lChild) > numberList.get(largest))
            largest = lChild;

        if(rChild < n && numberList.get(rChild) > numberList.get(largest))
            largest = rChild;

        if (largest != index) {
            int temp = numberList.get(index);
            numberList.set(index, numberList.get(largest));
            numberList.set(largest, temp);

            Heapify(numberList, n, largest, drill);
        }

        if (drill)
            System.out.println("HEAP AT END OF SHIFT: " + numberList);
    }
}
