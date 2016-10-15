package real;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dasom on 2016-10-08.
 */
public class Coordinate2 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input_data/nhn4_input.txt")))) {
            String input = br.readLine();
            String[] numStrList = input.split(" ");
            for (String numStr : numStrList) {
                numberList.add(Integer.parseInt(numStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 다음과 같은 방식으로 numberList와 number 변수를 사용할 수 있음

        // 내림차순으로 정렬
        Collections.sort(numberList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        });

        for (Integer number : numberList) {
            System.out.println(number);


        }


    }
}
