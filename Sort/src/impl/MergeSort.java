package impl;

import com.sun.scenario.effect.Merge;

/**
 * Created by dasom on 2016-10-06.
 */
public class MergeSort extends Sort {

    public MergeSort(int[] arr) {
        printArray(arr, MergeSort.class.getSimpleName());
        Divide(arr, 0, arr.length - 1);
        printArray(arr, MergeSort.class.getSimpleName());
    }

    private void Divide(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            Divide(arr, start, middle);
            Divide(arr, middle + 1, end);
            Conquer(arr, start, end, middle);
            printArray(arr, MergeSort.class.getSimpleName());
        }
    }

    private void Conquer(int[] arr, int start, int end, int middle) {
        int[] newArr = new int[end-start+1];
        int leftArrIndex = start;
        int rightArrIndex = middle+1;
        int newArrIndex = 0;

        while((leftArrIndex < rightArrIndex) && (leftArrIndex <= middle) && (rightArrIndex <= end)){
            if(arr[leftArrIndex] < arr[rightArrIndex]){
                newArr[newArrIndex++] = arr[leftArrIndex++];
            }else if(arr[leftArrIndex] > arr[rightArrIndex]){
                newArr[newArrIndex++] = arr[rightArrIndex++];
            }
        }

        while(leftArrIndex <= middle){
            newArr[newArrIndex++] = arr[leftArrIndex++];
        }

        while(rightArrIndex <= end){
            newArr[newArrIndex++] = arr[rightArrIndex++];
        }

        for(int i=0; i<newArrIndex; i++, start++){
            arr[start] = newArr[i];
        }
    }
}