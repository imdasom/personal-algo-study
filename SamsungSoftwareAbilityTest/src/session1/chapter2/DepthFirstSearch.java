package session1.chapter2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dasom on 2016-10-15.
 */
public class DepthFirstSearch {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("SamsungSoftwareAbilityTest\\data\\DepthFirstSearchInputData.txt"));
        String newLine = bufferedReader.readLine();
        String[] newLines = newLine.split(" ");
        int vertexNumber = Integer.parseInt(newLines[0]);
        int startVertex = Integer.parseInt(newLines[1]);

        List<>
    }
}
