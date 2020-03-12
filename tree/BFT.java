package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFT {

	class Node 
	{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
		}
	}
	

	Node insert(Node node,int data)
	{
		
		if(node==null)
		{
			return new Node(data);
		}
		else if(data<node.data)
		{
			node.left=insert(node.left, data);
		}
		else
		{
			node.right=insert(node.right, data);
		}
		return node;
	}
	
	void printLevelOrder(Node node)
	{
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
		
			Node s=q.poll();
			System.out.println(s.data+" ");
			if(s.left!=null)
			{
				q.add(s.left);
			}
			else if(s.right!=null)
			{
				q.add(s.right);
			}
			
		}
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
	public static void main(String[] args) {
		 BFT bft=new BFT();
		 Node root=bft.insert(null, 1);
		 bft.insert(root,2);
		 bft.insert(root,3);
		 bft.printLevelOrder(root);
		 
	}
	
}
