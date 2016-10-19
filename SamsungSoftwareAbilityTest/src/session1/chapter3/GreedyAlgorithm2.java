package session1.chapter3;

import java.io.*;
import java.util.*;

/**
 * Created by dasom on 2016-10-15.
 */
public class GreedyAlgorithm2 {
    public static final int V = 5;
    public static final int INF = 10000000;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new FileInputStream("SamsungSoftwareAbilityTest\\data\\GreedyAlgorithm2InputData.txt"));

        int startVertex = sc.nextInt();
        int endVertex = sc.nextInt();

        Vector<Element>[] adj = new Vector[V];
        for(int i=0; i<V; i++){
            adj[i] = new Vector<>();
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                int weight = sc.nextInt();
                if(weight != -1 && weight != 0){
                    adj[i].add(new Element(weight, j));
                }
            }
        }

        int dist[] = new int[V];
        fillData(dist, INF);

        boolean visited[] = new boolean[V];
        fillData(visited, false);

        PriorityQueue<Element> pq = new PriorityQueue<>();

        startDijkstraAlgorithm(startVertex, endVertex, adj, dist, visited, pq);
        printLeastDistance(dist);
    }

    public static void startDijkstraAlgorithm(int startVertex, int endVertex, Vector<Element>[] adj, int[] dist, boolean[] visited, PriorityQueue<Element> pq){
        dist[startVertex] = 0;
        pq.add(new Element(0, startVertex));

        while(!pq.isEmpty()){
            int curVertex;

            do{
                curVertex = pq.peek().vertex;
                pq.poll();
            }while(!pq.isEmpty() && visited[curVertex]);

            if(visited[curVertex]) break;

            visited[curVertex] = true;
            for(Element e : adj[curVertex]){
                int next = e.vertex;
                int totalDis = e.dis;
                int newDis = dist[curVertex] + totalDis;

                if(newDis < dist[next]){
                    dist[next] = newDis;
                    pq.add(new Element(dist[next], next));
                }
            }
        }
    }

    public static void fillData(int[] arr, int value){
        for(int i=0; i<arr.length; i++){
            arr[i] = value;
        }
    }

    public static void fillData(boolean[] arr, boolean value){
        for(int i=0; i<arr.length; i++){
            arr[i] = value;
        }
    }

    public static void printLeastDistance(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == INF) System.out.println("INF");
            else System.out.println(arr[i]);
        }
    }
}

class Element implements Comparable<Element> {
    int dis;
    int vertex;

    public Element(int dis, int vertex){
        this.dis = dis;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Element o) {
        return dis <= o.dis ? -1 : 1;
    }
}