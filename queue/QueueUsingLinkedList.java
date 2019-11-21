package queue;

public class QueueUsingLinkedList {
	
	public class Node
	{
		int data;
		Node link;
		Node(int data)
		{
			this.data=data;
		}
	}
	
	public Node front=null;
	public Node rear=null;
	
	
	public void enQueue(int data)
	{
		Node newNode =new Node(data);
		if(front==null&&rear==null)
		{
			front=rear=newNode;
		}
		else
		{
			rear.link=newNode;
			rear=newNode;
		}
		
	}
	

	public void deQueue()
	{
		
		if(front==null&&rear==null)
		{
			System.out.println("Queue Is Empty"); 
		}
		else
		{
			Node del=front;
			front=front.link;
			del.link=null;
		}
		
	}
	
	public void peek()
	{
		if(front==null&&rear==null)
		{
			System.out.println("Queue is Empty"); 
		}
		else
		{
			System.out.println("The Peek Value is:-"+front.data); 
		
		}
	}
	
	public void display()
	{
		Node temp=front;
		
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.link;
		}
		
		
	}
	public static void main(String[] args) {
    
		QueueUsingLinkedList q=new QueueUsingLinkedList();
		
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		
		q.deQueue();
		q.peek();
  }
	
}
