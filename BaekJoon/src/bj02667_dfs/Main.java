package bj02667_dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Created by dasom on 2017-01-14.
 */
public class Main {

    static int N;
    static int[][] list;

    static int startI = 0, startJ = 0;
    static int numOfDanji = 0;
    static ArrayList<Integer> numOfApartment;
    static int num = 0;
    static int index = 0;

    public static void main(String[] args) throws IOException {
        initValues();

        while (findFirstPoint()) {
            DFS(startI, startJ);
            numOfDanji++;
            numOfApartment.add(num);
            num = 0;
            index++;
        }

        System.out.println(numOfDanji);
        Collections.sort(numOfApartment);
        for (int n : numOfApartment){
            System.out.println(n);
        }
    }

    public static void DFS(int i, int j) {

        list[i][j] = 0;
        num++;

        if (i - 1 >= 0 && list[i - 1][j] == 1) {
            DFS(i - 1, j);
        }

        if (i + 1 < N && list[i + 1][j] == 1) {
            DFS(i + 1, j);
        }

        if (j - 1 >= 0 && list[i][j - 1] == 1) {
            DFS(i, j - 1);
        }

        if (j + 1 < N && list[i][j + 1] == 1) {
            DFS(i, j + 1);
        }

    }

    public static boolean findFirstPoint() {
        for (int i = startI; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (list[i][j] == 1) {
                    startI = i;
                    startJ = j;
                    return true;
                }
            }
        }
        return false;
    }

    public static void initValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\src\\bj02667_dfs\\input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N][N];
        numOfApartment = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String newLine = br.readLine();
            for (int j = 0; j < N; j++) {
                list[i][j] = newLine.charAt(j) - 48;
            }
        }
    }
}