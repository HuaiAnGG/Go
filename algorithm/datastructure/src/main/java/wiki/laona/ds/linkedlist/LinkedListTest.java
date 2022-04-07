package wiki.laona.ds.linkedlist;

/**
 * @author laona
 * @description 测试
 * @date 2022-04-07 21:28
 **/
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(new Node<>(1, null));
        linkedList.push(new Node<>(2, null));
        linkedList.push(new Node<>(3, null));
        linkedList.push(new Node<>(4, null));
        linkedList.push(new Node<>(5, null));
        linkedList.push(new Node<>(6, null));
        linkedList.show();

        System.out.println("===============================");

        linkedList.reverse();
        linkedList.show();

        System.out.println("===============================");

    }
}
