package session1.chapter3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dasom on 2016-10-15.
 */
public class GreedyAlgorithm2 {

    public static int[][] arr = new int[5][5];

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("SamsungSoftwareAbilityTest\\data\\GreedyAlgorithm2InputData.txt"));
        String newLine = bufferedReader.readLine();
        String[] items = newLine.split(" ");

        int startVertex = Integer.parseInt(items[0]);
        int endVertex = Integer.parseInt(items[1]);

        for(int i=0; i<5; i++){
            newLine = bufferedReader.readLine();
            items = newLine.split(" ");
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(items[j]);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
