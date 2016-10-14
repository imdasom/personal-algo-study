package sort.bj2751;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by pc on 2016-10-14.
 */
public class bj2751 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("Baekjoon\\input_data\\bj2751_input.txt"));

        int N = sc.nextInt();
        if(N<1 || N>1000000) return;

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
    }
}

class MaxHeapTree{
    int[] heap;
    int size;
    int lastIndex;

    public MaxHeapTree(){
        heap = null;
        size = 10;
        lastIndex = 0;
    }

    public MaxHeapTree(int size){
        this.size = size;
        heap = new int[size+1];
        for(int i=0; i<heap.length; i++)
            heap[i] = -1;

        lastIndex = 0;
    }

    public void insert(int data){
        if(heap[1] == -1){
            heap[1] = data;
            lastIndex = 1;
            return;
        }

        heap[lastIndex] = data;    //배열의 끝에 데이터를 넣는다.

        int child = lastIndex;
        int parent = lastIndex/2;
        int resultIndex = 0;
        while(parent >= 1){

            if(data > heap[parent]){
                resultIndex = parent;
                heap[child] = heap[parent];
            }
                parent = parent/2;
        }

        heap[resultIndex] = data;
        lastIndex++;

    }
}
