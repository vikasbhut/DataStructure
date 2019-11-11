package linkedlist;

public class CircularLinkedList {  
  
	
	public class Node
	{
		int data;
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
			tail=newNode;
		}
		tail.next=head;
	
	}

	public void printList()
	{
		Node current=head;
		if(head==null)
		{
			System.out.println("Circular Linked List Is Empty");
		}
		else
		{
			while(current.next!=head)
			{
				System.out.println(current.data);
				current=current.next;
			}
			System.out.println(current.data);
		}
	}
	
	
	
	
    public static void main(String[] args) {  
    
    	CircularLinkedList list=new CircularLinkedList();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	

    	//list.printList();
    	
    }  
}  