package impl.ids;

import domain.ListNode;

/**
 * Created by dasom on 2016-10-03.
 */
public class IdsCircularIdsLinkedList<T> extends IdsLinkedList {

    public void insertFirstNode(ListNode<T> newNode){
        // 만약
        if(isEmpty()){
            head = newNode;
            newNode.link = newNode;
        }else{

        }
    }

}
