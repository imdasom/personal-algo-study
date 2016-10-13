package real;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Coordinate {
    public Coordinate(){
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input_data/nhn1_input.txt")))) {
            String input = br.readLine();
            String[] numStrList = input.split(" ");
            for (String numStr : numStrList) {
                numberList.add(Integer.parseInt(numStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 입력받은 숫자를 오름차순으로 정렬
        Collections.sort(numberList);

        // 앞에서부터 두 숫자의 거리를 계산하여 Point 클래스 형식으로 다시 저장
        Vector<Point> distances = new Vector<>();
        for(int i=1; i<numberList.size(); i++){
            int num1 = numberList.get(i-1);
            int num2 = numberList.get(i);
            int distance = num2 - num1;
            distances.add(new Point(num1, num2, distance));
        }

        // 거리가 저장된 리스트를 기반으로 다시 정렬
        // 거리를 기준으로 오름차순으로 정렬한다.
        distances.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.distance < o2.distance) return -1;
                else if(o1.distance > o2.distance) return 1;
                else{
                    if((o1.num1+o1.num2) < (o2.num1+o2.num2)) return -1;
                    else return 1;
                }
            }
        });

        // 오름차순으로 정렬했으므로 첫번째 원소가 가장 가까운 거리를 가지는 포인트가 된다.
        // 결과를 출력한다.
        System.out.println(distances.get(0).num1 + " " + distances.get(0).num2);
    }
}

class Point{
    public int num1;
    public int num2;
    public int distance;

    public Point(int num1, int num2, int distance) {
        this.num1 = num1;
        this.num2 = num2;
        this.distance = distance;
    }
}