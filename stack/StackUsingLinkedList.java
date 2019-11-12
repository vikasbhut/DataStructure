package stack;

public class StackUsingLinkedList {

	public class Node
	{
		int data;
		Node link;
	}
	Node top=null;
	
	@SuppressWarnings("unused")
	public void push(int item)
	{
		Node temp=new Node();
		
		//If Heaf IS Full
		if(temp!=null)
		{
			temp.data=item;
			temp.link=top;
			top=temp;
		}
		else
		{
			System.out.println("Stack OverFlow");
		}
	}
	public int pop()
	{
		int item=0;
		Node temp;
		if(top==null)
		{
			System.out.println("Underflow");
		}
		else
		{
			temp=top;
			item=top.data;
			top=top.link;
			temp.link=null;
		}
		return item;
	}

	public static void main(String[] args) {
		
		StackUsingLinkedList list=new StackUsingLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		
		
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
	}
}
