package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode {
	int freq;
	char c;
	HuffmanNode left, right;
}

public class HuffmanCode {

	public static void main(String[] args) {
		// number of characters.
		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };

		PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(new Comparator<HuffmanNode>() {

			@Override
			public int compare(HuffmanNode o1, HuffmanNode o2) {
				return o1.freq - o2.freq;
			}
		});

		for (int i = 0; i < n; i++) {

			HuffmanNode node = new HuffmanNode();
			node.c = charArray[i];
			node.freq = charfreq[i];
			node.left = null;
			node.right = null;
			queue.add(node);
		}
		
		HuffmanNode root=null;
		while(queue.size()>1)
		{
			HuffmanNode x=queue.peek();
			queue.poll();
			HuffmanNode y=queue.peek();
			queue.poll();
			HuffmanNode f=new HuffmanNode();
			f.freq=x.freq+y.freq;
			f.left=x;
			f.right=y;
			root=f;
			queue.add(f);
		}
		printCode(root,"");
	}

	private static void printCode(HuffmanNode root, String string) {
		if(root.left==null&&root.right==null&&Character.isLetter(root.c))
		{
			System.out.println(root.c+":"+string);
			return;
		}
		printCode(root.left, string+"0");
		printCode(root.right, string+"1");
	}
}
