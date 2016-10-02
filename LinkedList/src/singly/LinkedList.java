package singly;

import core.ListNode;

/**
 * Created by dasom on 2016-10-02.
 */
public class LinkedList<T extends ListNode, U> {

    private ListNode<U> head;

    public LinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return (head==null);
    }

    public void insertLastNode(T newNode){
        if(isEmpty()){
            head = newNode;
            return;
        }

        ListNode<U> currentNode = head;
        while(true){
            if(currentNode.link == null){
                currentNode.link = newNode;
                break;
            }else{
                currentNode = currentNode.link;
            }
        }
    }

    public void insertMiddleNode(U frontData, U newData){
        if(isEmpty()){
            ListNode<U> newNode = new ListNode<U>(frontData);
            head = newNode;
            return;
        }

        ListNode<U> frontNode = searchNode(frontData);
        if(frontNode != null){
            ListNode<U> newNode = new ListNode<U>(newData);
            newNode.link = frontNode.link;
            frontNode.link = newNode;
        }else{
            System.out.println("Cannot find Node");
        }
    }

    public void reverseList(){
        ListNode<U> preNode = null;
        ListNode<U> currentNode = null;
        ListNode<U> nextNode = head;

        while (nextNode != null){
            preNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.link;
            currentNode.link = preNode;
        }

        head = currentNode;
    }

    public void deleteLastNode(){
        ListNode<U> currentNode = head;
        while(true){
            if(currentNode.link.link == null){
                currentNode.link = null;
                break;
            }else{
                currentNode = currentNode.link;
            }
        }
    }

    private ListNode<U> searchNode(U data){
        ListNode<U> resultNode = head;
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
        ListNode<U> currentNode = head;
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
