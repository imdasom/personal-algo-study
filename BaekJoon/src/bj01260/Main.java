package bj01260;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2017-01-14.
 */
public class Main {

    static int nV, nE, startV;
    static int[][] list;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        initValues();

        DFS(startV);
        visited = new boolean[nV];
        System.out.println();

        System.out.print(startV + " ");
        BFS(startV);
    }

    public static void DFS(int startV){
        System.out.print(startV + " ");
        visited[startV] = true;

        for (int v = 1; v < nV; v++) {
            if(!visited[v] && list[startV][v]==1){
                DFS(v);
            }
        }
    }

    public static void BFS(int startV){

        queue.offer(startV);
        visited[startV] = true;

        while(!queue.isEmpty()){
            int curV = queue.poll();

            for (int nextV = 1; nextV < nV; nextV++) {
                if(!visited[nextV] && list[curV][nextV]==1){
                    System.out.print(nextV + " ");
                    queue.offer(nextV);
                    visited[nextV] = true;
                }
            }
        }
    }

    public static void initValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\src\\bj01260\\input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken()) + 1;
        nE = Integer.parseInt(st.nextToken());
        list = new int[nV][nV];
        visited = new boolean[nV];
        startV = Integer.parseInt(st.nextToken());

        String newLine = null;
        while((newLine = br.readLine()) != null){
            st = new StringTokenizer(newLine);
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1][v2] = list[v2][v1] = 1;
        }
    }
}
