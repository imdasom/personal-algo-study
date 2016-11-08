import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dasom on 2016-11-08.
 */
public class Main {

    public static int SIZE = 7;
    public static int arr[][];
    public static boolean visited[];

    public static void main(String[] args) {

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

        BFS(0);
    }

    public static void BFS(int root){
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);
        visited[root] = true;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i=0; i<SIZE; i++){
                if(arr[temp][i] == 1 && visited[i] == false){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }


    public static void IdsBFS(int root){
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);
        visited[root] = true;

        while(!q.isEmpty()){

            int temp = q.poll();
            System.out.print(temp+" "); //방문

            for(int i=0; i<SIZE; i++){
                if(arr[temp][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
