package impl.ids;

import domain.ListNode;

/**
 * Created by dasom on 2016-10-02.
 */
public class IdsLinkedList<T> {

    protected ListNode<T> head;

    public IdsLinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return (head==null);
    }

    public void insertLastNode(ListNode<T> newNode){
        if(isEmpty()){
            head = newNode;
            return;
        }

        ListNode<T> currentNode = head;
        while(true){
            if(currentNode.link == null){
                currentNode.link = newNode;
                break;
            }else{
                currentNode = currentNode.link;
            }
        }
    }

    public void insertMiddleNode(T frontData, T newData){
        if(isEmpty()){
            ListNode<T> newNode = new ListNode<T>(frontData);
            head = newNode;
            return;
        }

        ListNode<T> frontNode = searchNode(frontData);
        if(frontNode != null){
            ListNode<T> newNode = new ListNode<T>(newData);
            newNode.link = frontNode.link;
            frontNode.link = newNode;
        }else{
            System.out.println("Cannot find Node");
        }
    }

    public void reverseList(){
        ListNode<T> preNode = null;
        ListNode<T> currentNode = null;
        ListNode<T> nextNode = head;

        while (nextNode != null){
            preNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.link;
            currentNode.link = preNode;
        }

        head = currentNode;
    }

    public void deleteLastNode(){
        ListNode<T> currentNode = head;
        while(true){
            if(currentNode.link.link == null){
                currentNode.link = null;
                break;
            }else{
                currentNode = currentNode.link;
            }
        }
    }

    private ListNode<T> searchNode(T data){
        ListNode<T> resultNode = head;
        while((resultNode != null)){
            if(data.equals(resultNode.data)){
                return resultNode;
            }else{
                resultNode = resultNode.link;
            }
        }
        return null;
    }

    public void printList(){
        ListNode<T> currentNode = head;
        while(true){
            if(currentNode.link == null){
                System.out.print(currentNode.data);
                break;
            }else{
                System.out.print(currentNode.data + " --> ");
                currentNode = currentNode.link;
            }
        }

        System.out.println();
    }
}
