package impl.jdk;

import java.util.LinkedList;

/**
 * Created by dasom on 2016-10-03.
 */
public class JdkLinkedList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    private JdkLinkedList(){
        size = 0;
        first = null;
        last = null;
    }

    private void linkFirst(E e){
        // 첫번째 노드로 추가

    }

    void linkLast(E e){
        // 마지막 노드로 추가

    }

    void linkBefore(E e, Node<E> succ){
        // e데이터를 가지는 노드를 생성하고 succ노드 뒤에 추가

    }

    private E unlinkFirst(Node<E> f){
        // 첫번째 노드 f를 삭제
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if(next == null){
            last = null;
        }else{
            next.prev = null;
        }
        size--;
        return element;
    }

    private E unlinkLast(Node<E> l){
        // 마지막 노드 l을 삭제
        E element = l.item;
        return element;
    }

    E unlink(Node<E> x){
        // 노드 x를 삭제하고 element를 반환
        E element = x.item;
        return element;
    }

    public E getFirst(){
        return first.item;
    }

    public E getLast(){
        return last.item;
    }

    public E removeFirst(){
        //Node<E> f = first;
        unlinkFirst(first);
        return first.item;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
