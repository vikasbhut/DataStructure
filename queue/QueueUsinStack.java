package queue;

import java.util.Stack;

public class QueueUsinStack {

	Stack<Integer> s1=new Stack<>();
	Stack<Integer> s2=new Stack<>();
	
	public void enqueue(int item)
	{
		s1.push(item);
	}
	public int dequeue()
	{
		int data=0;
		if(s2.isEmpty())
		{
			if(s1.isEmpty())
			{
				System.out.println("Queue Empty");
			}
			else
			{
				while (!s1.isEmpty()) {
				
					s2.push(s1.pop());
				}
				
		  }
		}
		return s2.pop();
	}
	public static void main(String[] args) {
		 QueueUsinStack q = new QueueUsinStack();  
		    q.enqueue(1);  
		    q.enqueue(2);  
		    q.enqueue(3);  
		  
		    System.out.println(q.dequeue());  
		    System.out.println(q.dequeue()); 
		    System.out.println(q.dequeue()); 
	}
}
