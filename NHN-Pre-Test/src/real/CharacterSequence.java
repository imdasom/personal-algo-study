package real;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterSequence {
    public enum State {VOWELS, CONSONANTS}

    public CharacterSequence() {
        String[] words = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int numOfVowels = 0;     // 모음의 갯수
        int numOfConsonants = 0; // 자음의 갯수

        for (String word : words) {

            State[] states = new State[word.length()];

            for (int i = 0; i < word.length(); i++) {
                char compared = word.charAt(i);

                // 모음인지 자음인지 체크한다.
                if (isVowles(compared)) {

                    // 만약 현재 char가 모음이라면, 이전 char도 모음인지 체크한다.
                    // 현재 인덱스가 i이므로, i-1번 인덱스의 state값과 비교하여 이전 state도 모음이라면
                    // 연속된 2개의 모음이 있는 것으로 판단한다.
                    // isVowlesState(...)메서드를 사용한다.
                    try {
                        states[i] = State.VOWELS;
                        if (isSateVowles(states, i-1)) {
                            numOfVowels++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // 아무 일도 하지 않음
                    } finally {
                        // 아무 일도 하지 않음
                    }

                } else {
                    // 만약 현재 char가 자음이라면, 이전 2개의 char가 자음인지 체크한다.
                    // 현재 인덱스가 i이므로, i-1번, i-2번 인덱스의 state값과 비교하여
                    // 연속된 3개의 자음이 있는 것으로 판단한다.
                    // isConsonantsState(...)메서드를 사용한다.
                    try {
                        states[i] = State.CONSONANTS;
                        if (isStateConsonants(states, i-1) && isStateConsonants(states, i-2)) {
                            numOfConsonants++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // 아무 일도 하지 않음
                    } finally {
                        // 아무 일도 하지 않음
                    }


                }
            }

        }

        System.out.println(numOfVowels);
        System.out.println(numOfConsonants);

    }

    public static boolean isVowles(char compared){
        if(compared == 'a'
                || compared == 'e'
                || compared == 'i'
                || compared == 'o'
                || compared == 'u') return true;
        else return false;
    }

    // 메소드 사용시 가독성을 위해 isStateVowles와 isStateConsonants 두개로 나누었다.
    // 원하는 배열에 인덱스가 State.VOWELS인지 State.CONSONANTS인지 판단한다.
    public static boolean isSateVowles(State[] states, int index){
        if(states[index] == State.VOWELS) return true;
        else return false;
    }

    public static boolean isStateConsonants(State[] states, int index){
        if(states[index] == State.CONSONANTS) return true;
        else return false;
    }

}