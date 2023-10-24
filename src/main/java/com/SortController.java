package com;

import com.sorts.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortController {
    public static void main(String[] args) {
        SortControl();
    }

    public static <T> void SortControl() {
        System.out.print("WELCOME TO THE SORT SYSTEM! USE THE 'HELP' COMMAND TO SEE A LIST OF VALID SORTS, OR " +
                         "'QUIT' TO EXIT\n");
        Scanner scan = new Scanner(System.in);
        List<T> input = InputParser(scan.nextLine().toLowerCase());

        while(true) {
            switch ((String) input.get(0)) {
                case ("bubble"):
                    BubbleSort.BubbleSortExample((Integer) input.get(1), (Boolean) input.get(2));
                    break;
                case ("selection"):
                    SelectionSort.SelectionSortExample((Integer) input.get(1), (Boolean) input.get(2));
                    break;
                case ("insertion"):
                    InsertionSort.InsertionSortExample((Integer) input.get(1), (Boolean) input.get(2));
                    break;
                case ("merge"):
                    MergeSort.MergeSortExample((Integer) input.get(1), (Boolean) input.get(2));
                    break;
                case ("quick"):
                    QuickSort.QuickSortExample((Integer) input.get(1), (Boolean) input.get(2));
                    break;
                case ("counting"):
                    CountingSort.CountingSortExample((Integer) input.get(1), (Boolean) input.get(2));
                    break;
                case ("radix"):
                    RadixSort.RadixSortExample((Integer) input.get(1), (Boolean) input.get(2));
                    break;
                case ("bucket"):
                    BucketSort.BucketSortExample((Integer) input.get(1), (Boolean) input.get(2), 10);
                    break;
                case ("help"):
                    System.out.print("CURRENT LIST OF SORTS:\n" +
                                     "BUBBLE\n" +
                                     "SELECTION\n" +
                                     "INSERTION\n" +
                                     "MERGE\n" +
                                     "QUICK\n" +
                                     "COUNTING\n" +
                                     "RADIX\n");
                    break;
                case ("quit"):
                    return;
                default:
                    System.out.print("NOT A VALID SORT. USE THE 'HELP' COMMAND TO SEE A LIST OF VALID SORTS, OR " +
                                     "'QUIT' TO EXIT\n");
                    break;
            }

            input = InputParser(scan.nextLine().toLowerCase());
        }
    }

    public static <T> List<T> InputParser (String input) {
        List<String> tokens = Arrays.asList(input.split("\\s+"));
        List<T> output = new ArrayList<T>();

        output.add((T) String.valueOf(tokens.get(0)));

        try {
            int value = Integer.parseInt(tokens.get(1));
            output.add((T) Integer.valueOf(value));
        } catch (Exception e) {
            output.add((T) Integer.valueOf(10));
        }

        try {
            output.add((T) Boolean.valueOf(((String) tokens.get(2)).equals("drill")));
        } catch (Exception e) {
            output.add((T) Boolean.valueOf(false));
        }

        return output;
    }
}
