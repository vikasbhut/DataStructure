package linkedlist;

public class CircularLinkedListTail {
	public class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}

	public Node tail=null;
	

	
	public void add(int data)
	{
		Node newNode=new Node(data);
		if(tail==null)
		{
			tail=newNode;
			tail.next=newNode;
		}
		else
		{
			newNode.next=tail.next;
			tail.next=newNode;
			tail=newNode;
		}
		}

	public void insertionAtBegining(int data)
	{
    	Node newNode=new Node(data);
    	if(tail==null)
		{
			tail=newNode;
			tail.next=newNode;
		}
		else
		{
			newNode.next=tail.next;
			tail.next=newNode;
			
		}
	}
	
	public void insertionAtEnd(int data)
	{
    	Node newNode=new Node(data);
    	if(tail==null)
		{
			tail=newNode;
			tail.next=newNode;
		}
		else
		{
			newNode.next=tail.next;
			tail.next=newNode;
			tail=newNode;
		}
    	}
	public int getLength(){
	
		int cnt=0;
		Node current=tail.next;
		while (current.next!=tail.next) {
			cnt++;
			current=current.next;
		}
		cnt++;
		return cnt;
		
	}
	public void insertionAtPos(int pos,int length,int data)
	{
		if(pos<0||pos>length)
		{
			System.out.println("Invalid position");
		}
		else if (pos==1) {
			insertionAtBegining(data);
		}
		else
		{
			Node temp=tail.next;
			Node newNode=new Node(data);
			int i=1;
			while(i<pos-1)
			{
				temp=temp.next;
				i++;
			}
			newNode.next=temp.next;
			temp.next=newNode;
		}
	}
	
	public void deletionAtBegin()
	{
		
		if(tail==null)
		{
			System.out.println("List is Empty");
		}
		else if(tail.next==tail)
		{
			tail.next=null;
			tail=null;
		}
		else
		{
			Node temp=tail.next;
			tail.next=temp.next;
			temp.next=null;
		}
	}
	
	public void deletionAtEnd()
	{
		if(tail==null)
		{
			System.out.println("List is Empty");
		}
		else if(tail.next==tail)
		{
			tail.next=null;
			tail=null;
		}
		else
		{
//			Node temp=tail.next;
//			while(temp.next.next!=tail.next)
//			{
//				temp=temp.next;
//			}
//			
//			temp.next=tail.next;
//			tail.next=null;
//			tail=temp;
			
			Node current=tail.next;
			Node prev=null;
			while(current.next!=tail.next)
			{
				prev=current;
				current=current.next;
			}
			prev.next=tail.next;
			tail=prev;
			current.next=null;
		}
	
		
		
		}
	
	public void printListRevese(Node t)
	{
	
			if(t.next!=tail.next)
			{
				printListRevese(t.next);
				System.out.println(t.data);
			}
			
		
	}
	
	
	public void deleteFromPos(int data)
	{
		if(tail==null)
		{
			System.out.println("List is Empty");
		}
		else if(tail.next==tail)
		{
			tail.next=null;
			tail=null;
		}
		else
		{
			Node temp=tail.next;
			while(temp.next.data!=data)
			{
				temp=temp.next;
			}
			Node temp2=temp.next;
			temp.next=temp.next.next;
			temp2.next=null;
		}
	}

	public void printList()
	{
		Node current=tail.next;
		if(tail==null)
		{
			System.out.println("Circular Linked List Is Empty");
		}
		else
		{
			while(current.next!=tail.next)
			{
				System.out.println(current.data);
				current=current.next;
			}
			System.out.println(current.data);
		}
	}
	
	public void reveseList()
	{
		if(tail==null)
		{
			System.out.println("List is Empty");
		}
		else if(tail.next==tail)
		{
			System.out.println(tail.data);
		}
		else
		{
			Node current=tail.next;
			Node prev=null;
			Node next=current.next;
			while(current!=tail)
			{
				prev=current;
				current=next;
				next=current.next;
				current.next=prev;
			}
			
			next.next=tail;
			tail=next;
			
		}
		
		
	}
	
	
    public static void main(String[] args) {  
    
    	CircularLinkedListTail list=new CircularLinkedListTail();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(5);
    	list.add(6);

//    	list.insertionAtBegining(0);
//    	list.printList();
    	
    	list.insertionAtPos(2,list.getLength(),9);
    	list.printList();

    	
    	//Node t=list.tail.next;
    	//list.printListRevese(t);
    	
//    	Node current=list.tail.next;
 //   	Node prev=list.tail;
   // 	list.printList();
    	
    }
}
