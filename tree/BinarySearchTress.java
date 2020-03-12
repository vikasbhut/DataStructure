package tree;

public class BinarySearchTress {
	

class Node
{
	int key;
	Node left;
	Node right;
	
	public Node(int key)
	{
		this.key=key;
	}
}

	
	
 Node insert(Node node,int key)
	{
	 	if(node==null)
	 		return new Node(key);
	 	if(key<node.key)
	 		node.left=insert(node.left, key);
	 	else
	 		node.right=insert(node.right, key);
	 	return node;
	}
	
	
   Node search(Node root,int key)
   {
	   if(root==null||root.key==key)
		   return root;
	   if(key<root.key)
		   return search(root.left, key);
	   else
		   return search(root.right,key);
   }
	static void printInOrder(Node tNode)
	{
		if(tNode!=null)
		{
			printInOrder(tNode.left);
			System.out.println(tNode.key);
			printInOrder(tNode.right);
		}
	}
	
	
	boolean isComplete(Node tNode)
	{
		 if(tNode==null)
			 return true;
		 if(tNode.left==null&&tNode.right==null)
			 return true;
		 else if(tNode.left!=null&&tNode.right!=null)
			 return isComplete(tNode.left)&&isComplete(tNode.right);
		 else 
			 return false;
	}
	
	
	int maxval(Node root)
	{
		int maxVal=root.key;
		while(root.right!=null)
		{
			maxVal=root.right.key;
			root=root.right;
		}
		return maxVal;
	}
	
	
	Node deleteRec(Node root,int key)
	{
		if(root==null)
			return root;
		else if(key<root.key)
			root.left=deleteRec(root.left, key);
		else if(key>root.key)
			root.right=deleteRec(root.right, key);
		else
		{
			if(root.left==null&&root.right==null)
			{
				root=null;
			}
			else if(root.left==null)
			{
				Node temp=root;
				root=root.right;
				temp=null;
			}
			else if(root.right==null)
			{
				Node temp=root;
				root=root.left;
				temp=null;
			}
			else
			{
				root.key=minVal(root.right);
				root.right=deleteRec(root.right,minVal(root.right));
			}
		}
		return root;
	}
	int minVal(Node root)
	{
		while(root.left!=null)
		{
			root=root.left;
		}
		return root.key;
	}
	
	
	public static void main(String[] args) {
    
		BinarySearchTress tree=new BinarySearchTress();
		Node root=tree.insert(null,50);
		tree.insert(root, 30); 
	    tree.insert(root, 20);  
	    tree.insert(root, 40); 
	    tree.insert(root, 70); 
	    tree.insert(root, 60); 
	    tree.insert(root, 80); 		
		
		
	    tree.printInOrder(root);
	    System.out.println(tree.isComplete(root));
	}
	
}
