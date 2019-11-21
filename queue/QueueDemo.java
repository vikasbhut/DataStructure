package queue;

public class QueueDemo {
	
	
	int arr[];
	int size;
	int front;
	int rear;
	
	public QueueDemo(int size)
	{
		this.size=size;
		arr=new int[size];
		front=rear=-1;
	}
	
	public void enQueue(int data)
	{
		if(rear==size-1)
		{
			System.out.println("Full");
			return;
		}
		else
		{
			arr[++rear]=data;
		}
	}
	
	
	public void deQueue()
	{
		if(front==-1)
		{
			System.out.println("Empty");
			return;
		}
		else
		{
			if(front==rear)
			{
				System.out.println("Dequeued element Is :-"+arr[front]); 
				front=rear=-1;
			}
			else
			{
				System.out.println("Dequeued element Is :-"+arr[front]);
				front++;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
    
  }
	
	
	
}
