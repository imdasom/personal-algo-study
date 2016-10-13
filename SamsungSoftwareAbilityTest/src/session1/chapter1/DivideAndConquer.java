package session1.chapter1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-12.
 */
public class DivideAndConquer {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("input_data/samsung_divide_and_conquer_input.txt"));

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        printArray(arr);
        divide(arr, 0, N-1);
        printArray(arr);
    }

    public static void divide(int[] arr, int start, int end){
        if(start < end){
            int middle = (start + end)/2;
            divide(arr, start, middle);
            divide(arr, middle+1, end);
            conquer(arr, start, middle, end);
        }
    }

    public static void conquer(int[] arr, int start, int middle, int end){
        int[] tempArr = new int[end-start+1];
        int tempArrIndex = 0;
        int leftIndex = start;
        int rightIndex = middle+1;

        while((leftIndex < rightIndex) && (leftIndex <= middle) && (rightIndex <= end)){

            if(arr[leftIndex] < arr[rightIndex]){
                tempArr[tempArrIndex++] = arr[leftIndex++];
            }else if(arr[rightIndex] < arr[leftIndex]){
                tempArr[tempArrIndex++] = arr[rightIndex++];
            }
        }

        while(leftIndex <= middle) tempArr[tempArrIndex++] = arr[leftIndex++];
        while(rightIndex <= end) tempArr[tempArrIndex++] = arr[rightIndex++];

        for(int i=0; i<tempArr.length; i++, start++){
            arr[start] = tempArr[i];
        }
    }

    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
