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
	
	
	public static void main(String[] args) {
    
		
		 InorderPreorderTree tree = new InorderPreorderTree(); 
	     char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
	     char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
	     
	     Node root=tree.buildTree(in, pre, 0, in.length-1);
	     tree.printInorder(root);
	     
  }
}
