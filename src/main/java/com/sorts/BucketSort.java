package com.sorts;

import com.RandomList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void BucketSortExample (int length, boolean drill, int buckets) {
        List<Integer> randomList = RandomList.CreateRandomList(length);
        System.out.println("---------------------------------");
        System.out.println("BUCKET SORT EXAMPLE");
        System.out.println("---------------------------------");
        System.out.println("UNSORTED LIST: " + randomList);

        List<List<Integer>> bucketList = new ArrayList<>();

        for (int i = 0; i < buckets; ++i) {
            bucketList.add(new ArrayList<>());
        }

        int max = Collections.max(randomList);
        int min = Collections.min(randomList);
        float bucketRange = (int) Math.ceil((double) (max - min) / buckets);
        for (int i = 0; i < randomList.size(); ++i) {
            int bucketIndex = (int) ((randomList.get(i) - min) / bucketRange);
            bucketList.get(bucketIndex).add(randomList.get(i));
        }

        int count = 1;
        for (List<Integer> bucket : bucketList) {
            if (drill) {
                System.out.println("BUCKET #" + count + ":" + bucket);
                ++count;
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        for (List<Integer> bucket : bucketList) {
            sortedList.addAll(QuickSort.QuickHelper(bucket, false));
        }

        System.out.println("SORTED LIST: " + sortedList);
        System.out.println("---------------------------------");
        System.out.println("TIME COMPLEXITY (BEST): O(n+k)");
        System.out.println("TIME COMPLEXITY (AVG): O(n)");
        System.out.println("TIME COMPLEXITY (WORST): O(n²)");
        System.out.println("SPACE COMPLEXITY: O(n + k)");
        System.out.println("STABLE: YES");
        System.out.println("---------------------------------");
    }
}
