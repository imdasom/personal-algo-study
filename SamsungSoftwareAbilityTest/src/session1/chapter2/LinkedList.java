package session1.chapter2;

import java.io.*;

/**
 * Created by dasom on 2016-10-13.
 */
public class LinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("SamsungSoftwareAbilityTest\\data\\LinkedListInputData.txt"));
        String newLine = bufferedReader.readLine();
        int N = Integer.parseInt(newLine);

        newLine = bufferedReader.readLine();
        String[] items = newLine.split(" ");

        IdsLinkedList linkedList = new IdsLinkedList();

        for (int i = 0; i < items.length; i++) {
            //System.out.println(items[i]);
            linkedList.insertNode(new ListNode(Integer.parseInt(items[i])));
            //linkedList.printList();
        }
        linkedList.printList();

        newLine = bufferedReader.readLine();
        items = newLine.split(" ");

        ListNode newNode = new ListNode(Integer.parseInt(items[0]));
        int newIndex = Integer.parseInt(items[1]);

        linkedList.insertNode(newNode, newIndex);
        linkedList.printList();

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\dasom\\Desktop\\personal_algo_study\\workspace-intellij\\SamsungSoftwareAbilityTest\\data\\LinkedListOutputData.txt"));

        writer.write(linkedList.toString());
        writer.close();

        System.out.println("쓰기완료");

    }
}

class ListNode {
    public int data;
    public ListNode link;

    public ListNode(int data) {
        this.data = data;
        this.link = null;
    }
}

class IdsLinkedList {

    private ListNode head;
    private ListNode first;
    private ListNode last;
    private int length;

    public IdsLinkedList() {
        this.head = null;
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public void insertNode(ListNode newNode) {
        if (head == null) {
            head = newNode;
            first = newNode;
            last = newNode;
            length++;
            return;
        }

        last.link = newNode;
        last = newNode;
        length++;
    }

    public void insertNode(ListNode newNode, int newIndex) {
        if (head == null) {
            return;
        }

        ListNode frontNode = head;
        for (int i = 1; i < newIndex; i++) {
            if (frontNode == null) return;
            frontNode = frontNode.link;
        }

        newNode.link = frontNode.link;
        frontNode.link = newNode;
        length++;
    }

    public void printList() {
        ListNode tempNode = head;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.link;
        }
        System.out.println();
    }

    public int[] toArray() {
        ListNode tempNode = head;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = tempNode.data;
            tempNode = tempNode.link;
        }
        return arr;
    }

    public String toString() {
        ListNode tempNode = head;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(tempNode.data).append(" ");
            tempNode = tempNode.link;
        }
        return sb.toString();
    }
}
