package impl;

/**
 * Created by dasom on 2016-10-07.
 */
public class QuickSort extends Sort{
    public enum Direction{TO_LEFT, TO_RIGHT};

    public QuickSort(int[] arr){
        printArray(arr, QuickSort.class.getSimpleName());
        mainQuickSort(arr, 0, arr.length-1);
        printArray(arr, QuickSort.class.getSimpleName());
    }

    public void mainQuickSort(int[] arr, int start, int end){
        if(start < end){
            int pivotIndex = QuickSorting(arr, start, end);
            printArray(arr, QuickSort.class.getSimpleName());
            mainQuickSort(arr, start, pivotIndex-1);
            mainQuickSort(arr, pivotIndex+1, end);
        }
    }

    public int QuickSorting(int[] arr, int start, int end){
        int pivot = arr[start];
        int toRightIndex = start;
        int toLeftIndex = end;
        Direction dir = Direction.TO_LEFT;

        while((toRightIndex != toLeftIndex)){
            if(dir == Direction.TO_RIGHT){
                if(arr[toRightIndex] > pivot){
                    arr[toLeftIndex--] = arr[toRightIndex];
                    dir = Direction.TO_LEFT;
                }else{
                    toRightIndex++;
                }

            }else if(dir == Direction.TO_LEFT) {
                if (arr[toLeftIndex] < pivot) {
                    arr[toRightIndex++] = arr[toLeftIndex];
                    dir = Direction.TO_RIGHT;
                }else{
                    toLeftIndex--;
                }
            }
        }

        if(toRightIndex == toLeftIndex){
            arr[toLeftIndex] = pivot;
        }

        return toLeftIndex;
    }
}
