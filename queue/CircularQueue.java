package queue;

public class CircularQueue {
	
	int arr[];
	int size;
	int front,rear;
	
	
	public CircularQueue(int size)
	{
		this.size=size;
		arr=new int[size];
	}
	
	public void deQueue()
	{
		if(front==rear)
		{
			System.out.println("Queue Is Empty"); 
		}
		else
		{
			front=(front+1)%size;
			System.out.println("Dequeued Element Is :-"+arr[front]); 
		}
	}
	
	public void enQueue(int item)
	{
	  rear=(rear+1)%size;
	  if(front==rear)
	  {
		  System.out.println("Queue is Full");
		  if(rear==0)
			  rear=size-1;
		  else
			  rear=rear-1;
	  }
	  else
	  {
		  arr[rear]=item;
	  }
	}
	
	public void display()
	{
		int i=front+1;
		while(i!=rear)
		{
			System.out.println(arr[i]);
			i=(i+1)%size;
		}
		System.out.println(arr[rear]); 
	}
	public static void main(String[] args) {
    
		 CircularQueue q=new CircularQueue(4);
		 q.enQueue(1);
		 q.enQueue(2);
		 q.enQueue(3);
		
		 q.display();
  }
	
	
}

