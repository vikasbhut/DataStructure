package linkedlist;

public class DoublyLinkedList {

	public Node head;
	public Node temp;
	public class Node
	{
		int data;
		Node prev;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}
	
	
	public void add(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=temp=newNode;
		}
		else
		{
			temp.next=newNode;
			newNode.prev=temp;
			temp=newNode;
			
		}
	}
	
	
	public void displayUsingRecursion(Node temp)
	{
		if(temp!=null)
		{
			System.out.println(temp.data);
			displayUsingRecursion(temp.next);
		}
		
	}
	public void displayReveseUsingRecursion(Node temp)
	{
		if(temp!=null)
		{
			displayReveseUsingRecursion(temp.next);
			System.out.println(temp.data);
		}
		
	}
	public void display()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		
	}
	
	public static void main(String[] args) {
	
		DoublyLinkedList list=new DoublyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
	
		Node temp=list.head;
		list.displayReveseUsingRecursion(temp);
	}
}
