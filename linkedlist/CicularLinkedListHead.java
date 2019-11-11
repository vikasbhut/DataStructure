package linkedlist;

public class CicularLinkedListHead {
	
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
	public Node temp=null;

	
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
			temp=newNode;
		}
		temp.next=head;
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
    
    	CicularLinkedListHead  list=new CicularLinkedListHead ();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	
    
    	list.printList();
    }

}
