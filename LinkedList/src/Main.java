import core.ListNode;
import singly.LinkedList;

/**
 * Created by dasom on 2016-10-02.
 */
public class Main {

    public static void main(String[] args){
        LinkedList<ListNode<String>, String> list = new LinkedList<>();
        list.insertLastNode(new ListNode<>("월"));
        list.insertLastNode(new ListNode<>("수"));
        list.insertLastNode(new ListNode<>("목"));
        list.insertLastNode(new ListNode<>("토"));
        list.insertLastNode(new ListNode<>("일"));
        list.printList();

        list.insertMiddleNode("월", "화");
        list.insertMiddleNode("목", "금");
        list.printList();

        list.reverseList();
        list.printList();

        list.deleteLastNode();
        list.printList();
    }
}
