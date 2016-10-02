package main.jdk.util;

/**
 * Created by dasom on 2016-09-28.
 */
public class IdsPriorityQueue<E> {

    private Object[] queue;      // item을 담는 배열
    private int size;       // 큐의 최대 사이즈
    private int length;     // item의 갯수(길이)
    private int front;      //
    private int rear;

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    public IdsPriorityQueue(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public IdsPriorityQueue(int capacity){
        queue = new Object[capacity];
    }

    public boolean isEmpty(){
        return (length == 0);
    }

    public void enQueue(E element){
        queue
    }
}
