import java.lang.reflect.Array;

class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private Class<T> type;

    // Constructor to initialize the doubly linked list
    public DoublyLinkedList(Class<T> type) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.type = type;
    }

    // Method to add an element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Method to remove the head of the list
    public void remove() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
        }
    }

    // Method to remove element at index X from the list
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            remove();
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        size--;
    }

    // Method to remove all elements of the list
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // Method to return the number of elements in the list
    public int size() {
        return size;
    }

    // Method to return an array of the elements in the list
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(type, size);
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    // Method to retrieve the head of the list (but does not remove it)
    public T element() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    // Method to retrieve the element at position X
    public T element(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Method to set the element at position X to value T
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }
}
