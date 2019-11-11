package linkedlist;

public class DoublyCircularLinkedList {

	
	public class Node
	{
		int data;
		Node next;
		Node prev;
		Node(int data)
		{
			this.data=data;
		}
	}
	
	public Node head=null;
	public Node tail=null;
	
	public void add(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=tail=newNode;
			head.next=head;
			head.prev=head;
		}
		else
		{
			tail.next=newNode;
			newNode.prev=tail;
			newNode.next=head;
			head.prev=newNode;
			tail=newNode;
		}
	}
	
	public void insertionAtBegin(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=tail=newNode;
			head.next=head;
			head.prev=head;
		}
		else
		{
			newNode.next=head;
			head.prev=newNode;
			newNode.prev=tail;
			tail.next=newNode;
			head=newNode;
		}
	}
	
	public void insertionAtEnd(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=tail=newNode;
			head.next=head;
			head.prev=head;
		}
		else
		{
			newNode.next=head;
			tail.next=newNode;
			newNode.prev=tail;
			head.prev=newNode;
			tail=newNode;
		}
	}
	
	public void insertAtPos(int data,int pos,int length)
	{
		
		if(pos<0||pos>length)
		{
			System.out.println("Invalid Position");
		}
		else
		{
			int i=1;
			Node newNode=new Node(data);
			Node temp=head;
			while(i<pos-1)
			{
				temp=temp.next;
				i++;
			}
			newNode.next=temp.next;
			newNode.prev=temp;
			temp.next.prev=newNode;
			temp.next=newNode;
		}
	}
	
	public int getLength()
	{
		int count=0;
		Node temp=head;
		while(temp!=tail)
		{
			count++;
			temp=temp.next;
		}
		//For Last Node
		count++;
		return count;
		
	}
	
	public void deleteAtBegin()
	{
		head=head.next;
		head.prev=tail;
		tail.next=head;
	}


	public void deleteAtEnd()
	{
		tail=tail.prev;
		tail.next=head;
		head.prev=tail;
	}

	public void deleteAtPos(int pos,int length)
	{
		if(pos<0||pos>length)
		{
			System.out.println("Invalid Position");
		}
		else
		{
			Node temp=head;
			int i=1;
			while(i<pos-1)
			{
				temp=temp.next;
				i++;
			}
			Node nodetodelete=temp.next;
			temp.next=nodetodelete.next;
			nodetodelete.next.prev=temp;
			nodetodelete.next=null;
			nodetodelete.prev=null;
		}
	}


	public void display()
	{	
		Node temp=head;
		while(temp!=tail)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
	public static void main(String[] args) {
		
		DoublyCircularLinkedList list=new DoublyCircularLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.deleteAtPos(2, list.getLength());
		list.display();
		
	}
	
}
