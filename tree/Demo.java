package tree;

import java.util.Scanner;

public class Demo {

	public class Node
	{
		int data;
		Node left;
		Node right;
	}
	
	
	
	Node buildTree()
	{
		Node newNode=new Node();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter data or -1 for no data:-");
		int data=sc.nextInt();
		if(data==-1)
		{
			return null;
		}
		
		newNode.data=data;
		System.out.println("Enter Left Of "+newNode.data);
		newNode.left=buildTree();
		System.out.println("Enter right of"+newNode.data);
		newNode.right=buildTree();
		return newNode;
	}
	
	
	void inorder(Node root)
	{
		if(root.left!=null)
			inorder(root.left);
			
		System.out.println(root.data);
		
		
		if(root.right!=null)
			inorder(root.right);
		
	}
	void preorder(Node root)
	{
		
		System.out.println(root.data);
		if(root.left!=null)
			preorder(root.left);
    	if(root.right!=null)
			preorder(root.right);
	}
	void postorder(Node root)
	{
		if(root.left!=null)
			postorder(root.left);
    	if(root.right!=null)
			postorder(root.right);
    	System.out.println(root.data);
	}
	
	void doubleOrder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.data);
			doubleOrder(root.left);
			System.out.println(root.data);
			doubleOrder(root.right);
		}
	}
	
	void tripleOrder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.data);
			tripleOrder(root.left);
			System.out.println(root.data);
			tripleOrder(root.right);
			System.out.println(root.data);
	
		}
	}
	
	void A(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.data);
			B(root.left);
			B(root.right);
		}
	}
	void B(Node root)
	{
		if(root!=null)
		{
			A(root.left);
			System.out.println(root.data);
			A(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		
		Demo tree=new Demo();
		Node root=tree.buildTree();
		tree.A(root);
	}
}
