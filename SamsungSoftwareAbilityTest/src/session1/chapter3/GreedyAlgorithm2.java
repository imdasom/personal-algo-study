package session1.chapter3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-15.
 */
public class GreedyAlgorithm2 {
    public static int[][] arr = new int[5][5];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new FileInputStream("SamsungSoftwareAbilityTest\\data\\GreedyAlgorithm2InputData.txt"));

        int startVertex = sc.nextInt();
        int endVertex = sc.nextInt();

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = sc.nextInt();
                //System.out.print(arr[i][j] + " ");
            }
            //System.out.println();
        }

        boolean[] visited = new boolean[5];
        int[] distances = new int[5]; //무한대로 초기화향 한다.
        for(int i=0; i<5; i++){
            visited[i] = false;
            distances[i] = 999;
        }

        int[] sequence = new int[5];
        int sequenceIndex = 0;

        //startVertex에 방문을 표시한다.
        int curVertex = startVertex;
        visited[curVertex] = true;
        distances[curVertex] = 0;
        sequence[sequenceIndex++] = curVertex;

        while(!isVisitedAllNode(visited)){
            System.out.println("\n while문 시작, curVertex : "+curVertex);
            //이 변수들은 min값 구하기 위해 쓰는거.
            int minDistance = distances[0];
            int minVertex = 0;

            for(int i=0; i<5; i++){
                if(arr[curVertex][i] == -1 || arr[curVertex][i] == 0)
                     continue;

                if (distances[i] != 999) {
                    int newDis = arr[curVertex][i] + distances[curVertex];
                    if (newDis < distances[i]) {
                        distances[i] = newDis;
                    }
                } else {
                    distances[i] = arr[curVertex][i];
                }

                if((minDistance == 0) || ((distances[i] < minDistance) && (!visited[i]))){
                    minDistance = distances[i];
                    minVertex = i;
                }
            }

            curVertex = minVertex;
            visited[curVertex] = true;   // 거리가 가장 작은 정점을 방문한다.
            System.out.println("sequenceIndex : "+sequenceIndex);
            sequence[sequenceIndex++] = curVertex;
            //System.out.printf("startVertex, visited[%d], sequence[%d] : %d, %b, %d\n", curVertex, (sequenceIndex-1), startVertex, visited[curVertex], sequence[sequenceIndex-1]);
        }

        printPath(sequence);
        System.out.println(distances[endVertex]);
    }

    public static boolean isVisitedAllNode(boolean[] visited){
        for(boolean visit : visited){
            if(!visit) return false;
        }
        return true;
    }

    public static void printPath(int[] sequence){
        for(int vertex : sequence){
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}