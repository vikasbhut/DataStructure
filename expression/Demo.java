package expression;

import queue.QueueUsingArray;

public class Demo {

	  int arr[];
	  int size;
	  int front;
	  int rear;
	  
	  public Demo(int size)
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
		  }
		  else
		  {
			  if(rear==-1)
			  {
				  front=rear=0;
				  arr[rear]=data;
			  }
			  else
			  {
				  arr[++rear]=data;
			  }
		  }
	  }
	  
	  public void deQueue()
	  {
		  if(front==-1)
			  System.out.println("Empty");
		  else
		  {
			  if(front==rear)
			  {
				  System.out.println(arr[front]);
				  front=rear=-1;
			  }
			  else
			  {
				  System.out.println(arr[front--]); 
			  }
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
