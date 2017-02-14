package bj09095;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2017-02-14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\src\\bj0905\\input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[10];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        int testCase = Integer.parseInt(st.nextToken());
        for (int i = 4; i < 11; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        for (int j = 0; j < testCase; j++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(arr[Integer.parseInt(st.nextToken())]);
        }

    }
}
