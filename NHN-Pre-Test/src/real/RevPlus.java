package real;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

/**
 * Created by dasom on 2016-10-08.
 */
public class RevPlus {
    public static void main(String[] args){
        int number = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write your code here
        int numberLength = (int)(Math.ceil(Math.log10(number)));   //몇 자리수 인지 저장.

        // 10의 n승으로 나누어 배열에 저장한다.
        // 10의 n승이 1이 될때까지 나누어 저장한다.
        int[] arr = new int[numberLength];
        for(int i=arr.length-1, j=numberLength-1; i>=0; i--, j--){
            int powOfTen = (int)Math.pow(10, j);
            arr[i] = (int)(number / powOfTen);
            number = (int)(number % powOfTen);
        }

        for(int i=0; i<arr.length; i++){

        }


        // 2. int totalNumber = number + reverse한 숫자
        // 3. totalNumber를 reverse한다.
        // 4. 다시 원래 숫자와 reverse한 숫자를 비교하여 같다면 대칭이므로 반환.

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}
