package queue;

public class CircularQueueUsingLinkedList {
	
	
	public class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}
	
	public Node front=null;
	public Node rear=null;
	
	
	public void enQueue(int data)
	{
		Node n=new Node(data);
		if(front==null&&rear==null)
		{
			front=rear=n;
			n.next=front;
		}
		else
		{
			rear.next=n;
			n.next=front;
			rear=n;
		}
	}
	
	public void deQueue()
	{
		Node deleted=front;
		front=front.next;
		deleted.next=null;
		rear.next=front;
		System.out.println(deleted.data); 
	}
	
	
	public void display()
	{
		Node temp=front;
		while(temp!=rear)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println(temp.data); 
	}
	
	public static void main(String[] args) {
    
		CircularQueueUsingLinkedList q=new CircularQueueUsingLinkedList();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
	
		q.display();
  }
	

}
