import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dasom on 2016-11-08.
 *
 * n 높이 마다 n개가 있는 트리를 주고, 노드마다 가중치가 있음 root에서 leaf노드까지 최소값을 구하는 문제
 */
public class TreeAndGraphTest {

    public static int SIZE = 7;
    public static int[][] arr;
    public static boolean[] visited;
    public static int cnt = 0;

    public static void main(String[] args){

        arr = new int[][]{
                {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 1},
                {0, 0, 1, 0, 0, 1, 0}
        };

        visited = new boolean[]{ false, false, false, false, false, false, false};

        IdsBFS(0);
        System.out.println(cnt);
    }

    public static void IdsBFS(int root){
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);
        visited[root] = true;
        cnt++;

        while(!q.isEmpty()){

            int temp  = q.poll();
            System.out.print(temp+" ");

            for(int i=0; i<SIZE; i++){
                if(arr[temp][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }

        System.out.println();
    }
}
