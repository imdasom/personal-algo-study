package core;

/**
 * Created by dasom on 2016-10-02.
 */
public class ListNode<T> {
    public T data;
    public ListNode link;

    public ListNode() {

    }

    public ListNode(T data) {
        this.data = data;
        this.link = null;
    }

    public ListNode(T data, ListNode link) {
        this.data = data;
        this.link = link;
    }
}
