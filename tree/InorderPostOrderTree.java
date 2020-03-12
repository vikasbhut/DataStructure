package tree;



public class InorderPostOrderTree {
	
	

class Node { 
    int data; 
    Node left, right; 
  
    Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
	
	
static int postIndex=7;

	Node buildUtil(int[] in,int[] pos,int start,int end)
	{
		
		if(start>end)
			return null;
		Node node=new Node(pos[postIndex--]);
		if(start==end)
			return node;
		int inIndex=search(in, start, end,node.data);
		node.right=buildUtil(in, pos,inIndex+1, end);
		node.left=buildUtil(in, pos, start,inIndex-1);
		return node;
		
	}
	

	
	int search(int[] arr,int start,int end,int value)
	{
		int i;
		for(i=start;i<=end;i++)
		{
			if(arr[i]==value)
			{
				return i;
			}
		}
			return i;
	}
	  void preOrder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	        System.out.print(node.data + " "); 
	        preOrder(node.left); 
	        preOrder(node.right); 
	    } 

	public static void main(String[] args) {
    
		InorderPostOrderTree tree=new InorderPostOrderTree();
		int in[] = new int[] {  4, 8, 2, 5, 1, 6, 3, 7  }; 
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 }; 
        int n = in.length; 
        Node root = tree.buildUtil(in, post,0,in.length-1); 
        System.out.println("Preorder of the constructed tree : "); 
        tree.preOrder(root); 
	     
	}

  

}
