package impl;

/**
 * Created by dasom on 2016-10-06.
 */
public class BubbleSort extends Sort {

    public BubbleSort(int[] arr){
        printArray(arr, BubbleSort.class.getSimpleName());

        for(int i=0; i<arr.length-1; i++){
            for(int j=1; j<arr.length-i; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                }
            }
            printArray(arr, BubbleSort.class.getSimpleName());
        }
    }
}
