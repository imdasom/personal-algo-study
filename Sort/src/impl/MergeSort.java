package impl;

import com.sun.scenario.effect.Merge;

/**
 * Created by dasom on 2016-10-06.
 */
public class MergeSort extends Sort {

    public MergeSort(int[] arr) {
        printArray(arr, MergeSort.class.getSimpleName());
        Divide(arr, 0, arr.length - 1);
    }

    private void Divide(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            Divide(arr, start, middle);
            Divide(arr, middle + 1, end);

            Conquer(arr, start, end, middle);
        }
    }

    private void Conquer(int[] arr, int start, int end, int middle) {
        int[] newArr = new int[end-start];

        int
    }
}