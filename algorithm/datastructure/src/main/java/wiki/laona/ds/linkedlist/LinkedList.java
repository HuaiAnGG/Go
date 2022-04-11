package wiki.laona.ds.linkedlist;

/**
 * @author laona
 * @description 链表
 * @date 2022-04-07 20:57
 **/
public class LinkedList<T> {

    private Node<T> head;
    private long length = 0;

    public void push(Node<T> node) {
        if (node == null) {
            throw new RuntimeException("插入的节点不能为空");
        }
        if (this.head == null) {
            this.head = node;
            this.length ++;
            return;
        }
        Node<T> temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(node);
        this.length ++;
    }

    public void reverse() {
        if (this.length == 0 || this.length == 1){
            return;
        }
        // Node<T> next = this.head;
        Node<T> temp;
        Node<T> reverse = null;
        while (this.head != null) {
            temp = this.head;
            this.head = this.head.getNext();
            temp.setNext(reverse);
            reverse = temp;
        }
        this.head = reverse;
    }

    public long size() {
        return length;
    }


    public void show() {
        if (this.length == 0 || this.length == 1) {
            System.out.println(this.head.toString());
        }
        Node<T> temp = this.head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
