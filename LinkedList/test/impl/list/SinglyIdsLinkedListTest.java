package impl.list;

import domain.ListNode;
import org.junit.Test;
import impl.ids.IdsLinkedList;

/**
 * Created by dasom on 2016-10-02.
 */
public class SinglyIdsLinkedListTest {

    @Test
    public void testSinglyLinkedList(){
        IdsLinkedList<String> list = new IdsLinkedList<>();
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
