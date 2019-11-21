package tree;

import java.util.Scanner;

public class BinaryTree {
	
	public class Node
	{
		int data;
		Node left;
		Node right;
	}
	
	
	
	public Node create()
	{
		Node newNode=new Node();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter data to insert into the node or -1 for no node :-");
		int data=sc.nextInt();
		if(data==-1)
		{
			return null;
		}
		newNode.data=data;
		System.out.println("Enter left Of node :- "+data);
		newNode.left=create();
		System.out.println("Enter right Of node :- "+data);
		newNode.right=create();
		return newNode;
		
	}
	
	
	public void inOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
		
	}
	public void preOrder(Node root)
	{
		
		if(root==null)
			return;
		else
		{
			System.out.println(root.data);
			preOrder(root.left);
		    preOrder(root.right);
		}
	}
	public void postOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			postOrder(root.left);
		    postOrder(root.right);
		    System.out.println(root.data);
		}
	}
	
	public void doubleOrder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.data);
			doubleOrder(root.left);
			System.out.println(root.data);
			doubleOrder(root.right);
		}
	}
	public void tripleOrder(Node root)
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
	
	public static void main(String[] args) {
    
		BinaryTree tree=new BinaryTree();
		Node root=tree.create();
		
//		System.out.println("Inorder :-" );
//		tree.inOrder(root);
//		
//		System.out.println("Preorder:-");
//		tree.preOrder(root);
//		
//		System.out.println("Postorder:-");
//		tree.postOrder(root);
//		
		 
		//System.out.println("Double Order:-");
		//tree.doubleOrder(root);
		
		System.out.println("Triple Order:-");
		tree.tripleOrder(root);
		
  }
}
