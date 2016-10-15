package session1.chapter3;

import java.io.*;

/**
 * Created by dasom on 2016-10-15.
 */
public class GreedyAlgorithm1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("SamsungSoftwareAbilityTest\\data\\GreedyAlgorithm1InputData.txt"));
        String newLine = bufferedReader.readLine();
        bufferedReader.close();
        String[] items = newLine.split(" ");
        int pointer = 0;

        int N = Integer.parseInt(items[pointer++]);
        Coin[] coins = new Coin[N];
        for (int i = 0; i < N; i++, pointer++) {
            coins[i] = new Coin(Integer.parseInt(items[pointer]));
        }
        int price = Integer.parseInt(items[pointer++]);
        int money = Integer.parseInt(items[pointer]);

        int change = money - price;

        int coinType = 0;
        while (coinType < N) {
            int numberOf = change / coins[coinType].amount;
            coins[coinType].numberOf = numberOf;

            if (numberOf == 0){

            }else{
                change = change - (coins[coinType].amount * numberOf);
            }
            coinType++;
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\dasom\\Desktop\\personal_algo_study\\workspace-intellij\\SamsungSoftwareAbilityTest\\data\\GreedyAlgorithm1OutputData.txt"));

        for(Coin coin : coins){
            bufferedWriter.write(coin.numberOf + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

class Coin {
    int amount;
    int numberOf;

    public Coin(int amount) {
        this.amount = amount;
        this.numberOf = 0;
    }
}
