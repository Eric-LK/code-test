package collection.my;

//@SuppressWarnings("unchecked")
public class MyLinkedList<T> {
    private int size;
    private Node<T> first;

    private static class Node<T>{
        T element;
        Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    public void add(T element, int index){
        if (index == 0){
            first =new Node<T>(element,first);
        }else{
            Node<T> node = getNode(index -1);
            node.next = new Node<>(element,node.next);
        }
        size ++;
    }


    public Node<T> getNode(int index){
        rangeCheck(index);

        Node<T> node = first;
        for (int i = 0; i < index; i++){
             node = node.next;
        }
        return node;
    }

    public void rangeCheck(int index){
        if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index){
       return getNode(index).element;
    }

    public T set(T element, int index){
        Node<T> node = getNode(index);
        T old = node.element;
        node.element = element;
        return old;
    }
}
