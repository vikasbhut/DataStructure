package queue;


public class QueueUsingStack {


	int arr[];
	int size;
	int top=-1;
	
	public QueueUsingStack(int size)
	{
		this.size=size;
		arr=new int[size];
	}
	public void push(int item)
	{
		if(top==size-1)
		{
			System.out.println("Stack is Full"); 
		}
		else
		{
			arr[++top]=item;
		}
	}
	public int pop()
	{
		if(top==-1)
		{
			System.out.println("underflow"); 
		}
		else
		{
			return arr[top--];
		}
		return -1;
	}
	
	public void reverse()
	{
		if(top==-1)
			return;
		else
		{
			int data=pop();
			reverse();
			insertAtBottom(data);
		}
		
	}
	public void insertAtBottom(int data)
	{
		if(top==-1)
			push(data);
		else
		{
			int i=pop();
			insertAtBottom(data);
			push(i);
		}
	}
	
	public void enQueue(int item)
	{
		push(item);
	}
	public int deQueue()
	{
		reverse();
		int pop=pop();
		reverse();
		return pop;
	}
	public static void main(String[] args) {
		QueueUsingStack q=new QueueUsingStack(4);
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		
		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue()); 
  }
	
}
