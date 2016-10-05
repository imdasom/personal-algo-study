package impl;

/**
 * Created by dasom on 2016-10-06.
 */
public class SelectionSort extends Sort{
    public SelectionSort(int[] arr){
        printArray(arr, SelectionSort.class.getSimpleName());

        // i는 첫번째 원소부터 마지막원소 전까지이다.(마지막 원소는 비교할 필요없음)
        // j(비교 대상)은 i+1번째 원소부터 마지막원소이다.
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] <= arr[i]){
                    swap(arr, i, j);
                }
            }
            printArray(arr, SelectionSort.class.getSimpleName());
        }
    }
}
