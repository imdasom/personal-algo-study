package impl.list;

import domain.ListNode;
import org.junit.Test;
import impl.LinkedList;

/**
 * Created by dasom on 2016-10-02.
 */
public class SinglyLinkedListTest {

    @Test
    public void testSinglyLinkedList(){
        LinkedList<ListNode<String>, String> list = new LinkedList<>();
        list.insertLastNode(new ListNode<>("월"));
        list.insertLastNode(new ListNode<>("수"));
        list.insertLastNode(new ListNode<>("일"));
        list.printList();

        list.insertMiddleNode("월", "금");
        list.printList();

        list.reverseList();
        list.printList();

        list.deleteLastNode();
        list.printList();
    }

}
