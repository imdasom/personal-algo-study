package cp;

/**
 * Created by dasom on 2016-10-22.
 */
public class solution1 {
    public static void main(String[] args) {

        String[] inputs = {"a", "b", "c", "d", "e", "f", "g", "h"};
        inputs = solution(inputs);

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i]+", ");
        }
        System.out.println("{");
    }

    public static String[] solution(String[] inputs) {
        StringQueue[] sqArr = new StringQueue[3];
        sqArr[0] = new StringQueue("arr1");
        sqArr[1] = new StringQueue("arr2");
        sqArr[2] = new StringQueue("arr3");

        for (int i = 0; i < inputs.length; i += 3) {
            try {
                sqArr[0].enqueue(inputs[i]);
                sqArr[1].enqueue(inputs[i + 1]);
                sqArr[2].enqueue(inputs[i + 2]);
            } catch (ArrayIndexOutOfBoundsException e) {
                // 아무 일도 하지 않음.
            }
        }

        String[] resultArr = new String[inputs.length];
        for (int i = 0; i < resultArr.length; i += 3) {
            try {
                resultArr[i] = sqArr[0].dequeueWithFormattingString();
                resultArr[i + 1] = sqArr[1].dequeueWithFormattingString();
                resultArr[i + 2] = sqArr[2].dequeueWithFormattingString();
            } catch (ArrayIndexOutOfBoundsException e) {
                // 아무 일도 하지 않음.
            }
        }

        return resultArr;
    }
}

class StringQueue {
    private String queueName;
    private String[] arr;
    private int front;
    private int rear;
    private int length;
    private int maxSize;
    private final int DEFALUT_MAX_SIZE = 10;

    public StringQueue(String queueName) {
        this.queueName = queueName;
        this.arr = new String[DEFALUT_MAX_SIZE];
        this.front = 0;
        this.rear = 0;
        this.length = 0;
        this.maxSize = DEFALUT_MAX_SIZE;
    }

    public StringQueue(String queueName, int maxSize) {
        this.queueName = queueName;
        this.arr = new String[maxSize];
        this.front = 0;
        this.rear = 0;
        this.length = 0;
        this.maxSize = maxSize;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public boolean enqueue(String item) {
        if (front == maxSize) return false;

        arr[rear++] = item;
        length++;
        return true;
    }

    public String dequeue() {
        if (isEmpty()) return null;

        String item = arr[front];
        arr[front++] = "";
        length--;
        return item;
    }

    public String dequeueWithFormattingString() {
        String item = dequeue();
        if (item == null) return null;

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(queueName).append(", ").append(item).append("]");
        return sb.toString();
    }
}