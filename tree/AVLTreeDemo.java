package tree;

public class AVLTreeDemo {
	
	private class Node
	{
		int data;
		Node left;
		Node  right;
		int height;
		
		Node(int data)
		{
			this.data=data;
			this.height=1;
		}
	}
	
	private Node root;
	
	
	private Node rightRotate(Node c)
	{
		Node b=c.left;
		Node t3=b.right;
		
		b.right=c;
		c.left=t3;
		
		c.height=Math.max(height(c.left),height(c.right))+1;
		b.height=Math.max(height(b.left),height(b.right))+1;
		
		return b;
    }
	private Node leftRotate(Node c)
	{
		Node b=c.right;
		Node t3=b.left;
		b.left=c;
		c.right=t3;
		c.height=Math.max(height(c.left),height(c.right))+1;
		b.height=Math.max(height(b.left),height(b.right))+1;
		return b;
    }
	
	
	private int  height(Node n)
	{
		if(n!=null)
			return n.height;
    return 0;
	}
	
	private int bf(Node n)
	{
		if(n!=null)
		{
			return height(n.left)-height(n.right);
		}
		return 0;
	}
	public void insert(int data)
	{
		this.root=insert(this.root, data);
	}
	private Node insert(Node n,int data)
	{
		if(n==null)
			return new Node(data);
		else if(data<n.data)
			n.left=insert(n.left, data);
		else
			n.right=insert(n.right,data);
		
		n.height=Math.max(height(n.left),height(n.right))+1;
		int bf=bf(n);
		
		if(bf>1&&data<n.left.data)
		{
			return rightRotate(n);
		}
		if(bf<-1&&data>n.right.data)
		{
			return leftRotate(n);
		}
		if(bf>1&&data>n.left.data)
		{
			n.left=leftRotate(n.left);
			return rightRotate(n);
		}
		if(bf<-1&&data<n.right.data)
		{
			n.right=rightRotate(n.right);
			return leftRotate(n);
		}
		return n;
	}
	public void display()
	{
		display(this.root);
	}
	private void display(Node n)
	{
		if(n!=null)
		{
			String str="";
			if(n.left==null)
				str+=".";
			else
				str+=n.left.data;
			str+=" => "+n.data+" <= ";
			if(n.right==null)
				str+=".";
			else
				str+=n.right.data;
			System.out.println(str);
			display(n.left);
			display(n.right);
		}
		
	}
	
	public Node findMin(Node n)
	{
		while(n.left!=null)
		{
			n=n.left;
		}
		return n;
	}
	
	public Node deleteNode(Node n,int data)
	{
		if(n==null)
			return n;
		else if(data<n.data)
			n.left=deleteNode(n.left, data);
		else if(data>n.data)
			n.right=deleteNode(n.right, data);
		else
		{
			if(n.left==null&&n.right==null)
			{
			    System.out.println("deleting "+data);
				n=null;
			}
			else if(n.left==null)
			{
				Node temp=n;
			    System.out.println("deleting "+data);
			    n=n.right;
			    temp=null;
			}
			else if(n.right==null)
			{
				Node temp=n;
			    System.out.println("deleting "+data);
			    n=n.left;
			    temp=null;
			}
			else
			{
				Node min=findMin(n.right);
				n.data=min.data;
				n.right=deleteNode(n.right, min.data);
			    System.out.println("deleting "+data);
			  }
			}
		if(n==null)
		{
			return n;
		}
		
		n.height=Math.max(height(n.left),height(n.right))+1;
		int bf=bf(n);
		
		if(bf>1&&bf(n.left)>=0)
		{
			return rightRotate(n);
		}
		if(bf<-1&&bf(n.right)<=0)
		{
			return leftRotate(n);
		}
		if(bf>1&&bf(n.left)<=0)
		{
			n.left=leftRotate(n.left);
			return rightRotate(n);
		}
		if(bf<-1&&bf(n.right)>=0)
		{
			n.right=rightRotate(n.right);
			return leftRotate(n);
		}
		return n;
		
		
	}
	 void preOrder(Node node)  
	    {  
	        if (node != null)  
	        {  
	            System.out.print(node.data + " ");  
	            preOrder(node.left);  
	            preOrder(node.right);  
	        }  
	    }  
	public static void main(String[] args) {
		AVLTreeDemo tree=new AVLTreeDemo();  
		  tree.root = tree.insert(tree.root, 12);  
	        tree.root = tree.insert(tree.root, 10);  
	        tree.root = tree.insert(tree.root, 13);  
	        tree.root = tree.insert(tree.root, 6);  
	        tree.root = tree.insert(tree.root, 11);  
	        tree.root = tree.insert(tree.root, 5);  
	        
	        tree.display();;
	        
	       }
	
}
