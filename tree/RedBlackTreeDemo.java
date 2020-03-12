package tree;

public class RedBlackTreeDemo {

	private class Node
	{
		int data;
		Node parent;
		Node left;
		Node right;
		int color;
	}
	
	private Node root;
	private Node TNULL;
	
	
	public RedBlackTreeDemo()
	{
		TNULL=new Node();
		TNULL.parent=null;
		TNULL.right=null;
		TNULL.color=0;
		TNULL.left=null;
		root=TNULL;
	}
	
	
	public void rightRotate(Node x)
	{
		 Node y = x.left;
		    x.left = y.right;
		    if (y.right != TNULL) {
		      y.right.parent = x;
		    }
		    y.parent = x.parent;
		    if (x.parent == null) {
		      this.root = y;
		    } else if (x == x.parent.right) {
		      x.parent.right = y;
		    } else {
		      x.parent.left = y;
		    }
		    y.right = x;
		    x.parent = y;
	}
	public void leftRoate(Node x)
	{
		 Node y = x.right;
		    x.right = y.left;
		    if (y.left != TNULL) {
		      y.left.parent = x;
		    }
		    y.parent = x.parent;
		    if (x.parent == null) {
		      this.root = y;
		    } else if (x == x.parent.left) {
		      x.parent.left = y;
		    } else {
		      x.parent.right = y;
		    }
		    y.left = x;
		    x.parent = y;
	}
	
	public void insert(int key)
	{
		Node node=new Node();
		node.data=key;
		node.parent=null;
		node.right=TNULL;
		node.left=TNULL;
		node.color=1;
		Node x=root;
		Node y=null;
		while(x!=TNULL)
		{
			y=x;
			if(node.data<x.data)
			{
				x=x.left;
			}
			else
			{
				x=x.right;
			}
		}
		node.parent=y;
		if(y==null)
		{
			root=node;
		}
		else if(node.data<y.data)
		{
			y.left=node;
		}
		else
		{
			y.right=node;
		}
		if(node.parent==null)
		{
			node.color=0;
			return;
		}
		fixInsert(node);
	}
	 public Node minimum(Node node) {
		    while (node.left != TNULL) {
		      node = node.left;
		    }
		    return node;
		  }
	 
	 public void rbTransplant(Node u,Node v)
	 {
		 if(u.parent==null)
		 {
			 this.root=v;
		 }
		 if(u==u.parent.left)
		 {
			 u.parent.left=v;
		 }
		 else
		 {
			 u.parent.right=v;
		 }
		 v.parent=u.parent;
	 }
	 
	 public void deleteNodeHelper(Node node,int key)
	 {
		 Node z=TNULL;
		 Node x,y;
		 while(node!=TNULL)
		 {
			 if (node.data == key) {
			        z = node;
			      }
			      if (node.data <= key) {
			        node = node.right;
			      } else {
			        node = node.left;
			      }
		 }
		 y=z;
		 int color=y.color;
		 if(z.left==TNULL)
		 {
			 x=z.right;
			 rbTransplant(z, z.right);
		 }
		 else  if(z.right==TNULL)
		 {
			 x=z.left;
			 rbTransplant(z, z.left);
		 }
		 else
		 {
			 y=minimum(z.right);
			 color=y.color;
			 x=y.right;
			 if(y.parent==z)
			 {
				 x.parent=y;
			 }
			 else
			 {
				rbTransplant(y, y.right);
				y.right=z.right;
				y.right.parent=y;
			 }
			 rbTransplant(z, y);
			 y.left=z.left;
			 y.left.parent=y;
			 y.color=z.color;
		 }
		 if(color==0)
		 {
			 fixDelete(x);
		 }
	 }
	 public void fixDelete(Node x)
	 {
		 Node s;
		 while(x!=root&&x.color==0)
		 {
			if(x==x.parent.left)
			{
			 s=x.parent.right;
			 if(s.color==1)
			 {
				 s.color=0;
				 x.parent.color=1;
				 leftRoate(x.parent);
				s=x.parent.right;
			 }
			 else
			 {
				 if(s.left.color==0&&s.right.color==0)
				 {
					 s.color=1;
					 x=x.parent;
				 }
				 else
				 {
					 if(s.right.color==0)
					 {
						 s.left.color=0;
						 s.color=1;
						 rightRotate(s);
				            s = x.parent.right;
				          }
				          s.color = x.parent.color;
				          x.parent.color = 0;
				          s.right.color = 0;
				          leftRoate(x.parent);
				          x = root;
					 
				 }
			 }
			}
			else {
		        s = x.parent.left;
		        if (s.color == 1) {
		          s.color = 0;
		          x.parent.color = 1;
		          rightRotate(x.parent);
		          s = x.parent.left;
		        }
		        if (s.right.color == 0 && s.right.color == 0) {
		          s.color = 1;
		          x = x.parent;
		        } else {
		          if (s.left.color == 0) {
		            s.right.color = 0;
		            s.color = 1;
		            leftRoate(s);
		            s = x.parent.left;
		          }
		          s.color = x.parent.color;
		          x.parent.color = 0;
		          s.left.color = 0;
		          rightRotate(x.parent);
		          x = root;
		        }
		      }
		    }
		 x.color=0;
	 }
	public void fixInsert(Node k)
	{
		Node u;
		while(k.parent.color==1)
		{
			if(k.parent==k.parent.parent.left)
			{
				u=k.parent.parent.right;
				if(u.color==1)
				{
					u.color=0;
					k.parent.parent.color=1;
					k.parent.color=0;
					k=k.parent.parent;
				}
				else
				{
					if(k==k.parent.right)
					{
						k=k.parent;
						leftRoate(k);
					}
					k.parent.parent.color=1;
					k.parent.color=0;
					rightRotate(k.parent);
					
				}
			}
			else
			{
				u=k.parent.parent.left;
				if(u.color==1)
				{
					u.color=0;
					k.parent.parent.color=1;
					k.parent.color=0;
					k=k.parent.parent;
				}
				else
				{
					if(k==k.parent.left)
					{
						k=k.parent;
						rightRotate(k);
					}
					k.parent.parent.color=1;
					k.parent.color=0;
					leftRoate(k.parent);
					
				}
			}
			if(k==root)
			{
				break;
			}
		}
		root.color=0;
	}
	 public void printTree() {
		    printHelper(this.root, "", true);
		  }
	 private void printHelper(Node root, String indent, boolean last) {
		    if (root != TNULL) {
		      System.out.print(indent);
		      if (last) {
		        System.out.print("R----");
		        indent += "   ";
		      } else {
		        System.out.print("L----");
		        indent += "|  ";
		      }
		      String sColor = root.color == 1 ? "RED" : "BLACK";
		      System.out.println(root.data + "(" + sColor + ")");
		      printHelper(root.left, indent, false);
		      printHelper(root.right, indent, true);
		    }
		  }
	 public static void main(String[] args) { 
		 RedBlackTreeDemo bst = new RedBlackTreeDemo();
		    bst.insert(55);
		    bst.insert(40);
		    bst.insert(65);
		    bst.insert(60);
		    bst.insert(75);
		    bst.insert(57);
		    bst.insert(70);
		    bst.printTree();
		 
		    System.out.println("\nAfter deleting:");
		    bst.deleteNodeHelper(bst.root,40);
		    bst.printTree();
	
	}
}
