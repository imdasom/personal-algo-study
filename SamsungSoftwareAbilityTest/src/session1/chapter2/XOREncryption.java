package session1.chapter2;

import java.io.*;

/**
 * Created by dasom on 2016-10-15.
 */
public class XOREncryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("SamsungSoftwareAbilityTest\\data\\XOREncryptionInputData.txt"));
        String key = bufferedReader.readLine();
        String data = bufferedReader.readLine();
        bufferedReader.close();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<key.length(); i++){
            sb.append((char)(key.charAt(i)^data.charAt(i)));
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\dasom\\Desktop\\personal_algo_study\\workspace-intellij\\SamsungSoftwareAbilityTest\\data\\XOREncryptionOutputData.txt"));
        bufferedWriter.write(sb.toString());
        bufferedWriter.newLine();
        bufferedWriter.write(data);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
