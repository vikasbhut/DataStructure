package queue;

public class QueueUsingArray {

  int arr[];
  int size;
  int front;
  int rear;

  public QueueUsingArray(int size) {

    this.size = size;
    arr = new int[size];
    front = rear = -1;
  }

  public boolean isEmpty() {
    return front == -1;
  }

  public boolean isFull() {
    return rear == size - 1;
  }

  public void enQueue(int data) {

    if (isFull()) {
      System.out.println("OverFlow");
    } else if (rear == -1) {
      rear = front = 0;
      arr[rear] = data;
    } else {
    	
    	arr[++rear]=data;
    }
  }

  public void deQueue() {
	  
	  if(isEmpty())
	  {
		  System.out.println("UnderFlow"); 
	  }
	  else 
	  {
		  System.out.println("Dequeued element Is:-"+arr[front]); 
		  if(front==rear)
		   front=rear=-1;
		  else
			  front++;
	  }
	  
  }

  public static void main(String[] args) {
    QueueUsingArray q = new QueueUsingArray(5);
    q.enQueue(1);
    q.enQueue(2);
    q.enQueue(3);
    q.enQueue(4);
    q.enQueue(5);

    q.deQueue();
    q.deQueue();
    q.deQueue();
    q.deQueue();
    q.deQueue();
  }
}
