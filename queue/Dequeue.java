package queue;

public class Dequeue {

  public class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
      this.data = data;
    }
  }

  public Node front = null;
  public Node rear = null;

  public void insertAtFront(int data) {

    Node newNode = new Node(data);
    if (front == null && rear == null) {
      front = rear = newNode;
    } else {
      front.prev = newNode;
      newNode.next = front;
      front = newNode;
    }
  }

  public void insertAtRear(int data) {

    Node newNode = new Node(data);
    if (front == null && rear == null) {
      front = rear = newNode;
    } else {
      rear.next = newNode;
      newNode.prev = rear;
      rear = newNode;
    }
  }

  public void removeAtFront() {
    Node first = front;
    front = front.next;
    front.prev = null;
    first.next = null;
  }

  public void removeAtRear() {
    Node first = rear;
    first.prev = null;
    rear = rear.prev;
    rear.next = null;
  }

  public int getFirst() {

    return front.data;
  }

  public int getLast() {
    return rear.data;
  }

  public void display() {
    Node temp = front;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  public static void main(String[] args) {

    Dequeue deque = new Dequeue();
    deque.insertAtFront(2);
    deque.insertAtFront(1);
    deque.insertAtRear(3);
    deque.insertAtRear(4);

    deque.display();

    deque.removeAtFront();
    deque.display();
    System.out.println("First element in the deque " + deque.getFirst());
    System.out.println("Last element in the deque " + deque.getLast());
  }
}
