import algorithm.Jungol1370;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-08.
 */
public class Main {
    public static final int NUMBER = 0;
    public static final int START_TIME = 1;
    public static final int END_TIME = 2;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("input_data/jo1370_input.txt"));
        int N = sc.nextInt();

        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            arr[i][NUMBER] = sc.nextInt();
            arr[i][START_TIME] = sc.nextInt();
            arr[i][END_TIME] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[END_TIME] <= o2[END_TIME] ? -1 : 1;
            }
        });

        ArrayList<int[]> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            if (list.get(list.size() - 1)[END_TIME] <= arr[i][START_TIME]) {
                list.add(arr[i]);
            }
        }

        System.out.println(list.size());
        for (int[] meetingRoom : list) {
            System.out.print(meetingRoom[NUMBER] + " ");
        }

    }
}
