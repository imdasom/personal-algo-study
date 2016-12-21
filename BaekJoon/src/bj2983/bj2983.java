package bj2983;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-02.
 */
public class bj2983 {
    public static LinkedPlant[] plants;
    public static LinkedPlant frog;

    public bj2983() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input_data/bj2983_input.txt"));

        int N = sc.nextInt();
        int K = sc.nextInt();
        String directions = sc.next();

        plants = new LinkedPlant[N];
        for(int i=0; i<N; i++) {
            plants[i] = new LinkedPlant(new Plant(sc.nextInt(), sc.nextInt()));

            // 연결리스트에 추가한다.
            for (int j = i - 1; j >= 0; j--) {
                //System.out.println(i+", "+j);
                plants[i].insertPlant(plants[j]);
                plants[j].insertPlant(plants[i]);
            }
        }

        frog = plants[0];
        plants[0].getMain().removePlant();

        int i = 0;
        while(i < K){
            //System.out.println("점프 전 : "+frog.getMain().x+" "+frog.getMain().y);
            char newDirection = directions.charAt(i);
            LinkedPlant newPlant = frog.getProximatePlant(newDirection);
            if(newPlant == null) break;
            frog = newPlant;
            frog.getMain().removePlant();
            //System.out.println("점프 후 : "+frog.getMain().x+" "+frog.getMain().y+"\n");
            i++;
        }

        System.out.println(frog.getMain().x+" "+frog.getMain().y);
    }
}
