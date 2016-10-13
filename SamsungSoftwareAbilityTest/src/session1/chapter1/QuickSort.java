package session1.chapter1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-12.
 */
public class QuickSort {
    public enum Direction{TO_LEFT, TO_RIGHT}

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("input_data/samsung_quick_sort_input.txt"));

        int[] myNumbers = new int[10];
        int[] realNumbers = new int[10];

        for(int i=0; i<10; i++){
            myNumbers[i] = sc.nextInt();
        }
        for(int i=0; i<10; i++){
            realNumbers[i] = sc.nextInt();
        }


        printArray(myNumbers);
        printArray(realNumbers);

        quickSort(myNumbers, 0, myNumbers.length - 1);
        quickSort(realNumbers, 0, realNumbers.length - 1);

        printArray(myNumbers);
        printArray(realNumbers);

        int result = checkCorrectNumber(myNumbers, realNumbers);
        System.out.println(result);
    }

    public static void quick(int[] arr, int start, int end){
        if (start < end) {
            int middle = quickSort(arr, start, end);

            quickSort(arr, start, middle);
            quickSort(arr, middle + 1, end);
        }
    }

    public static int quickSort(int[] arr, int start, int end) {
        int toRightIndex = start;
        int toLeftIndex = end;
        Direction dir = Direction.TO_LEFT;

        int pivot = arr[start]; // 피봇을 설정한다.

        while ((toRightIndex != toLeftIndex)) {
            if (dir == Direction.TO_LEFT) {
                if (arr[toLeftIndex] < pivot) {
                    arr[toRightIndex++] = arr[toLeftIndex];
                    dir = Direction.TO_RIGHT;
                } else {
                    toLeftIndex--;
                }

            } else if (dir == Direction.TO_RIGHT) {
                if (arr[toRightIndex] > pivot) {
                    arr[toLeftIndex--] = arr[toRightIndex];
                    dir = Direction.TO_LEFT;
                } else {
                    toRightIndex++;
                }
            }
        }

        return (toRightIndex-1);
    }

    public static int checkCorrectNumber(int[] comparedArr, int[] realArr){
        int result = 0;

        for(int i=0; i<comparedArr.length; i++){
            if(comparedArr[i] == realArr[i]) result++;
        }

        return result;
    }

    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
