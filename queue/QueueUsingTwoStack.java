package queue;

import java.util.Stack;

public class QueueUsingTwoStack {
	
	Stack<Integer> s1=new Stack<>();
	Stack<Integer> s2=new Stack<>();
	
	
	public void enQueue(int data)
	{
		s1.push(data);
	}
	public int  deQueue()
	{
		if(s2.isEmpty())
		{
			if(s1.isEmpty())
			{
				System.out.println("Queue Is Empty"); 
			}
			else
			{
				while(!s1.isEmpty())
				{
					s2.push(s1.pop());
				}
			}
		}
		return s2.pop();
	}
	public static void main(String[] args) {
    
		QueueUsingTwoStack q=new QueueUsingTwoStack();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		
		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
		
  }
	
	
}
