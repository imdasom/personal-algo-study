package impl;

/**
 * Created by dasom on 2016-10-06.
 */
public class Sort {

    public void printArray(int[] arr, String simpleName){
        System.out.print(simpleName + " : ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
