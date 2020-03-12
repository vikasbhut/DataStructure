package tree;

public class RecursiveToCountNode {

	class Node {
		char data;
		Node left, right;

		Node(char item) {
			data = item;
			left = right = null;
		}
	}

	static int preIndex = 0;

	Node buildTree(char[] in, char[] pre, int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;
		Node tNode = new Node(pre[preIndex++]);

		if (inStart == inEnd)
			return tNode;
		int inIndex = search(in, inStart, inEnd, tNode.data);
		tNode.left = buildTree(in, pre, inStart, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
		return tNode;

	}

	int search(char[] arr, int inStart, int inEnd, char value) {
		int i;
		for (i = inStart; i <= inEnd; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}

	int NumberOfNode(Node tNode) {
		if (tNode == null)
			return 0;
		else
			return 1 + NumberOfLeaf(tNode.left) + NumberOfLeaf(tNode.right);
	}

	int NumberOfLeaf(Node tNode) {
		if (tNode == null)
			return 0;
		if (tNode.left == null && tNode.right == null)
			return 1;
		else
			return NumberOfLeaf(tNode.left) + NumberOfLeaf(tNode.right);
	}

	int NumberOfNonLeaf(Node tNode) {
		if (tNode == null)
			return 0;
		if (tNode.left == null && tNode.right == null)
			return 0;
		else
			return (1 + NumberOfNonLeaf(tNode.left) + NumberOfNonLeaf(tNode.right));

	}

	int NumberOfFullNode(Node tNode) {
		if (tNode == null)
			return 0;
		if (tNode.left == null && tNode.right == null) {
			return 0;
		}
		if (tNode.left != null && tNode.right != null) {
			return 1 + NumberOfFullNode(tNode.left) + NumberOfFullNode(tNode.right);
		}
		return 0;
	}
	
	int height(Node tNode)
	{
		if(tNode==null)
			return 0;
		if(tNode.left==null&&tNode.right==null)
			return 0;
		int l=height(tNode.left);
		int r=height(tNode.right);
		return 1+Math.max(l, r);
	}

	public static void main(String[] args) {
		RecursiveToCountNode tree = new RecursiveToCountNode();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };

		Node root = tree.buildTree(in, pre, 0, in.length - 1);
		System.out.println("Total Number Of Node:-" + tree.NumberOfNode(root));
		System.out.println("Total Number Of Leaf Node:-" + tree.NumberOfLeaf(root));
		System.out.println("Total Number Of Non Leaf Node:-" + tree.NumberOfNonLeaf(root));
		System.out.println("Number of full node" + tree.NumberOfFullNode(root));
		System.out.println("Height:-"+tree.height(root));
	}

}
