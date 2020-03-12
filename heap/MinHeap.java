package heap;

public class MinHeap {
	private int[] Heap;
	private int maxSize;
	private int size;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		size = 0;
		Heap = new int[maxSize];
		Heap[0] = Integer.MIN_VALUE;
	}

	public int parent(int pos) {
		return pos / 2;
	}

	public int left(int pos) {
		return 2 * pos;
	}

	public int right(int pos) {
		return 2 * pos + 1;
	}

	public boolean isLeaf(int pos) {
		return pos > size / 2 && pos <= size;
	}

	public void swap(int fpos, int spos) {
		int temp;
		temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
	}

	public void minHepify(int pos) {
		if(isLeaf(pos))
		{
			return;
		}
		if(Heap[pos]>Heap[left(pos)]||Heap[pos]>Heap[right(pos)])
		{
			if(Heap[left(pos)]<Heap[right(pos)])
			{
				swap(pos,left(pos));
				minHepify(left(pos));
			}
			else
			{
				swap(pos,right(pos));
				minHepify(right(pos));
			}
		}
	}

	public void insert(int element) {
		Heap[++size]=element;
		int current=size;
		while(Heap[parent(current)]>Heap[current])
		{
			swap(parent(current),current);
			current=parent(current);
		}
	}

	public int extractMin() {
		int popped = Heap[1];
		Heap[1] = Heap[size - 1];
		minHepify(1);
		return popped;
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out
					.print("Parent :-" + Heap[i] + " Left Child :-" + Heap[2 * i] + " Right child " + Heap[2 * i + 1]);
			System.out.println();
		}
	}


	public static void main(String[] arg) {
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
	
		minHeap.print();
		System.out.println("The min val is " + minHeap.extractMin());
	}
}
