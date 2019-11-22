package tree;


class Node { 
    char data; 
    Node left, right; 
  
    Node(char item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
public class InorderPreorderTree {
	
	
	
	static int preIndex=0;
	
	Node buildTree(char[] in,char[] pre,int inStart,int inEnd)
	{
		if(inStart>inEnd)
			return null;
     	Node tNode=new Node(pre[preIndex++]);
		
		if(inStart==inEnd)
			return tNode;
		int inIndex=search(in, inStart, inEnd,tNode.data);
		tNode.left=buildTree(in, pre, inStart, inIndex-1);
		tNode.right=buildTree(in, pre, inIndex+1, inEnd);
		return tNode;
		
	}
	
	int search(char[] arr,int inStart,int inEnd,char value)
	{
		int i;
		for(i=inStart;i<=inEnd;i++)
		{
			if(arr[i]==value)
				return i;
		}
		return i;
	}
	
	
	
	void printInorder(Node node)
	{
		if(node==null)
			return;
		else
		{
			printInorder(node.left);
			System.out.println(node.data);
			printInorder(node.right);
		}
	}
	
	
	int noOfNode(Node t)
	{
		if(t==null)
			return 0;
		else
			return noOfNode(t.left)+noOfNode(t.right)+1;
	}
	int noOfLeave(Node t)
	{
		if(t==null)
			return 0;
		if(t.left==null&&t.right==null)
			return 1;
		return noOfLeave(t.left)+noOfLeave(t.right);
	}
	
	int noOfNonLeave(Node t)
	{
		if(t==null)
			return 0;
		if(t.left==null&&t.right==null)
			return 0;
		return noOfNonLeave(t.left)+noOfNonLeave(t.right)+1;
	}
	int  noOfFullNode(Node t)
	{
		if(t==null)
				return 0;
		if(t.left==null&&t.right==null)
			return 0;
		return noOfFullNode(t.left)+noOfFullNode(t.right)+((t.left!=null&&t.right!=null)?1:0);
	}
	
	
	int heightOfTree(Node t)
	{
		if(t==null)
			return 0;
		if(t.left==null&&t.right==null)
			return 0;
		int leftTreeHeight=heightOfTree(t.left);
		int rightTreeHeight=heightOfTree(t.right);
		return (1+((leftTreeHeight>rightTreeHeight)?leftTreeHeight:rightTreeHeight));
	}
	
	public static void main(String[] args) {
    
		
		 InorderPreorderTree tree = new InorderPreorderTree(); 
	     char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
	     char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
	     
	     Node root=tree.buildTree(in, pre, 0, in.length-1);
	     tree.printInorder(root);
	     
	     
	     System.out.println("Height OF Tree:-"+tree.heightOfTree(root));
	     System.out.println("Total Node :-"+tree.noOfNode(root));
	     System.out.println("Leave Node :-"+tree.noOfLeave(root));
	     System.out.println("Non leave Node :-"+tree.noOfNonLeave(root));
	     System.out.println("Full Node :-"+tree.noOfFullNode(root));
	     System.out.println("Non Full Node:-"+(tree.noOfNonLeave(root)-tree.noOfFullNode(root)));
	     
  }
}
