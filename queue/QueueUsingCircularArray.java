package queue;

import java.awt.Dialog.ModalExclusionType;

public class QueueUsingCircularArray {

	int arr[];
	int size,front,rear;
	
	public QueueUsingCircularArray(int cap)
	{
		arr=new int[cap];
		this.size=cap;
		this.front=0;
		this.rear=0;
	}
	
	public void enqueue(int data)
	{
		rear=(rear+1)%size;
		if(front==rear)
		{
			System.out.println("Queue IS Full");
			if(rear==0)
				rear=size-1;
			else
				rear=rear-1;
		}
		else
		{
			arr[rear]=data;  
		}
	}
	
	public int  dequeue()
	{
		int data = 0;
		if(front==rear)
		{
			System.out.println("Queue IS Empty");
		}
		else
		{
			front=(front+1)%size;
			data=arr[front];
		}
		return data;
	}
	public static void main(String[] args) {
		
		QueueUsingCircularArray q=new QueueUsingCircularArray(4);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
	}
}
