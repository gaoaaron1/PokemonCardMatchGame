package drivers;

public class SinglyLinkedListTest<T> {
    private NodeTest<T> head;
    private NodeTest<T> tail;
    private NodeTest<T> temp;
    private int size;

    public SinglyLinkedListTest() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addLast(T elem) {
        if(head == null){
            head = new NodeTest<T>();
            head.element = elem;
            tail = head;
            size++;
        } else  {
            temp = new NodeTest<T>();
            temp.element = elem;
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            size++;
        }  

    }
    void print(){
        temp = head;
        while(temp  != null){
            System.out.println(temp.element);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedListTest<Integer> list = new SinglyLinkedListTest<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.print();

    }
}