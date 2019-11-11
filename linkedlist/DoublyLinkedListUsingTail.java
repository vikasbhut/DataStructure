package linkedlist;

public class DoublyLinkedListUsingTail {

	
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
	
	public Node head=null;
	public Node tail=null;
	
	public void add(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=tail=newNode;
		}
		else
		{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
	}
	
	public void insertAtBegin(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
		}
	}
	
	public void insertAtEnd(int data)
	{
		Node newNode=new Node(data);
		tail.next=newNode;
		newNode.prev=tail;
		tail=newNode;
	}
	
	public void insertAfterPos(int data,int pos,int length)
	{
		Node newNode=new Node(data);
		if(pos<0||pos>length)
		{
			System.out.println("Invalid Position");
		}
		else
		{
			Node temp=head;
			int i=1;
			while (i<pos) {
				temp=temp.next;
				i++; 
			}
			newNode.next=temp.next;
			temp.next=newNode;
			newNode.prev=temp;
			newNode.next.prev=newNode;
			
		}
	}
	public void insertAtPos(int data,int pos,int length)
	{
		Node newNode=new Node(data);
		if(pos<0||pos>length)
		{
			System.out.println("Invalid Position");
		}
		else if(pos==1)
		{
			insertAtBegin(data);
		}
		else
		{
			Node temp=head;
			int i=1;
			while (i<pos-1) {
				temp=temp.next;
				i++; 
			}
			newNode.next=temp.next;
			temp.next=newNode;
			newNode.prev=temp;
			newNode.next.prev=newNode;
			
		}
	}
	public void display()
	{
		Node temp=head;
		while (temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public int getLength()
	{
		Node temp=head;
		int count=0;;
		while (temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}

	public void deleteFromBegin()
	{
		if(head==null)
		{
			System.out.println("List is empty");
		}
		else
		{
			Node temp=head;
			head=head.next;
			head.prev=null;
			temp.next=null;
			}
	}
	public void deleteAtEnd()
	{
		if(head==null)
		{
			System.out.println("List is empty");
		}
		else
		{
			Node temp=tail;
			tail.prev.next=null;
			tail=tail.prev;
			temp.next=null;
		}
	}
	
	
	public void deleteAtPos(int pos)
	{
        	Node temp=head;
			int i=1;
			while(i<pos-1)
			{
				temp=temp.next;
				i++;
			}
			Node temp2=temp.next;
			temp.next=temp2.next;
			temp2.next.prev=temp2.prev;
			temp2.next=null;
			temp2.prev=null;
	}
	
	public void reveseList()
	{
		Node current=head;
		Node nextnode=null;
		
		while(current!=null)
		{
			nextnode=current.next;
			current.next=current.prev;
			current.prev=nextnode;
			current=nextnode;
		}
		
		current=head;
		head=tail;
		tail=current;
	}
	
	
	public static void main(String[] args) {
		
		DoublyLinkedListUsingTail usingTail=new DoublyLinkedListUsingTail();
		usingTail.add(1);
		usingTail.add(2);
		usingTail.add(3);
		usingTail.add(4);
		usingTail.add(5);
		usingTail.add(6);
		usingTail.add(7);
		usingTail.add(8);
		
		usingTail.reveseList();
		usingTail.display();
		
		
		
	}
}
