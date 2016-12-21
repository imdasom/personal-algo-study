package bj2606;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2016-11-30.
 *
 * virusCounter를 사용하는 대신, Visited를 이용하는 방법도 있다.
 * 하지만 별도의 카운터를 사용하는게 빠르다.
 */
public class BreadthFirstSearch {

    public static void main(String[] args) throws IOException {
        //BufferedReader와 StringTokenizer 사용하여 읽어오는 방법. --> 이게 훨씬 빠르다.
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\input_data\\bj2606_input.txt")));
        StringTokenizer st = null;

        int nV = Integer.parseInt(br.readLine());
        int nE = Integer.parseInt(br.readLine());

        int[][] ad = new int[nV][nV];
        boolean[] visited = new boolean[nV];
        int virusCounter = 0;

        for (int i = 0; i < nE; i++) {

            //배열인덱스는 0부터 시작이므로 -1을 한다.
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            ad[v1][v2] = ad[v2][v1] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            // 현재 정점을 방문한다.
            int cur = queue.poll();

            for(int i=0; i<nV; i++){
                if(ad[cur][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                    virusCounter++;
                }
            }

        }

        System.out.println(virusCounter);
    }
}
