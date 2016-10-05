package impl;

/**
 * Created by dasom on 2016-10-06.
 */
public class InsertionSort extends Sort{

    public InsertionSort(int[] arr){
        printArray(arr, InsertionSort.class.getSimpleName());

        // 삽입정렬은 두번째 원소부터 마지막 원소까지 체크한다.
        // 체크할 원소를 임시 변수에 저장하고 이전원소들과 비교한다.
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            /*int j = i-1;
            while( (j>=0) && (key<arr[j])){
                swap(arr, j, j+1);
                j--;
            }
            arr[j+1] = key;*/

            int j=i-1;
            for(; j>=0; j--){
                if(key <= arr[j]){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = key;

            printArray(arr, InsertionSort.class.getSimpleName());
        }
    }
}
