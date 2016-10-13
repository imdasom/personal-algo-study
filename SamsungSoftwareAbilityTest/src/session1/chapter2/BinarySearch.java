package session1.chapter2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-13.
 */
public class BinarySearch {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("SamsungSoftwareAbilityTest\\input_data\\BinarySearchInputData.txt"));
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int checkNum = sc.nextInt();

        printArray(arr);
        mainQuickSort(arr, 0, N - 1);
        printArray(arr);

        System.out.println((getIndex(arr, 0, N-1, checkNum)+1));
    }

    public static int getIndex(int[] arr, int start, int end, int item) {
        int result = 0;
        int middle = (start + end) / 2;

        if(arr[middle] == item){
            result = middle;
        }

        if(item < arr[middle]){
            result = getIndex(arr, start, middle, item);

        }else if(arr[middle] < item){
            result = getIndex(arr, middle+1, end, item);
        }

        return result;

    }

    public static void mainQuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = sort(arr, start, end);

            mainQuickSort(arr, start, middle);
            mainQuickSort(arr, middle + 1, end);
        }
    }

    public static int sort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int leftIndex = start;
        int rightIndex = end;
        boolean direction = false; // false면 왼쪽으로 이동, true면 오른쪽으로 이동.

        while ((leftIndex != rightIndex)) {
            if (direction) {
                if (arr[leftIndex] > pivot) {
                    arr[rightIndex] = arr[leftIndex];
                    direction = false;
                    rightIndex--;
                } else {
                    leftIndex++;
                }

            } else {
                if (arr[rightIndex] < pivot) {
                    arr[leftIndex] = arr[rightIndex];
                    direction = true;
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }

        return leftIndex;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
