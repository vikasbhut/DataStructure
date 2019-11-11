package linkedlist;

public class LinkedList {

	static Node Head;
	Node head;
	static class Node
	{
		char data;
		Node next;
		Node(char data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	static void printList(Node head)
	{
		while(head!=null)
		{
			System.out.println(head.data);
			head=head.next;
		}
	}
	
	
	static void printListUsingRecursion(Node head)
	{
		if(head!=null)
		{
			System.out.println(head.data);
			printListUsingRecursion(head.next);
		}
	}
	static void printListInReverseUsingRecursion(Node head)
	{
		if(head!=null)
		{
			printListInReverseUsingRecursion(head.next);
			System.out.println(head.data);
		}
	}

	static void insertAtStart(Node head,Node newnode)
	{
		newnode.next=head;
		head=newnode;
		printList(head);
	}
	static void insertAtEnd(Node head,Node newnode)
	{
		Node temp=head;
		while (temp.next!=null) {
				temp=temp.next;	
		}
		temp.next=newnode;
		printList(head);
	}
	
	static void insertAfter(Node head,Node newnode,char data)
	{
		Node temp=head;
		while (temp.data!=data) {
				temp=temp.next;	
		}
		newnode.next=temp.next;
		temp.next=newnode;
		printList(head);
	}

	static void deleteNodeAtStart(Node head)
	{
		head=head.next;
		printList(head);
	}
	
	static void deleteNodeAtEnd(Node head)
	{
		Node tmp=head;
		while (tmp.next.next!=null) {
			tmp=tmp.next;
		}
		tmp.next=null;
		printList(head);
	}
	
	static void deleteNodeBetween(Node head,char data)
	{
		Node tmp=head;
		while (tmp.next.data!=data) {
			tmp=tmp.next;
		}
		tmp.next=tmp.next.next;
		
		printList(head);
	}
	static void copyLastNodeToFirst(Node head)
	{
		Node p=head;;
		Node q=null;
		
		while (p.next!=null) {
			q=p;
			p=p.next;
			}
		
		p.next=head;
		head=p;
		q.next=null;
		printList(head);
	}
	
	static void reveseLinkedList(Node head)
	{
		
		Node prev=null;
		Node next=null;
		Node cur=head;
		
		while(cur!=null)
		{
			next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
		}
		head=prev;
		printList(head);
	
	}
	
	
	static void getLength(Node head)
	{
		Node temp=head;
		int count=0;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		System.out.println("No Of Node :-"+count);
	}
	static void reverseListUsingRecursion(Node prev,Node cur)
	{
		if(cur!=null)
		{
			reverseListUsingRecursion(cur, cur.next);
			cur.next=prev;
		}
		else
		{
			Head=prev;
		}
	}
	public static void main(String[] args) {
	
		LinkedList list=new LinkedList();
		list.head=new Node('A');
		
		Node second=new Node('B');
		Node third=new Node('C');
		Node four=new Node('D');
		list.head.next=second;
		second.next=third;
		third.next=four;
	
		
		//reverseListUsingRecursion(null,list.head);
		//printList(Head);
		
		getLength(list.head);
	}
	
}
