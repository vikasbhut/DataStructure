package heap;
public class MaxHeap {

	int[] Heap;
	int maxSize;
	int size;
	public MaxHeap(int maxSize)
	{
		this.maxSize=maxSize;
		size=0;
		Heap=new int[maxSize];
		Heap[0]=Integer.MAX_VALUE;
	}

	public int left(int pos)
	{
		return 2*pos;
	}
	public int right(int pos)
	{
		return 2*pos+1;
	}
	public int parnet(int pos)
	{
		return pos/2;
	}
	public boolean isLeaf(int pos)
	{
		return pos>=size/2&&pos<size;
	}
	public void swap(int fpos,int spos)
	{
		int temp=Heap[fpos];
		Heap[fpos]=Heap[spos];
		Heap[spos]=temp;
	}
	public void maxHeapify(int pos)
	{
		
		if(isLeaf(pos))
			return;
		if(Heap[pos]<Heap[left(pos)]||Heap[pos]<Heap[right(pos)])
		{
			if(Heap[left(pos)]>Heap[right(pos)])
			{
				swap(left(pos),pos);
				maxHeapify(left(pos));			
			}
			else
			{
				swap(right(pos),pos);
				maxHeapify(right(pos));
			}
		}
		
	}
	
	public void insert(int item)
	{
		Heap[++size]=item;
		int current=size;
		while(Heap[current]>Heap[parnet(current)])
		{
			swap(current,parnet(current));
			current=parnet(current);
		}
	}
	
	public int extractMax()
	{
		int popped=Heap[1];
		Heap[1]=Heap[size--];
		maxHeapify(1);
		return popped;
	}
	
	private void print() {
		
		for(int i=1;i<size/2;i++)
		{
			System.out.println("Parent:-"+Heap[i]+" "+"Left Child:-"+Heap[2*i]+" "+"Right Child:-"+Heap[2*i+1]);
		}
	}
	public static void main(String[] arg) {
		System.out.println("The Max Heap is ");
		MaxHeap maxHeap = new MaxHeap(15);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);
		maxHeap.print();
		System.out.println("The max val is " + maxHeap.extractMax());
		maxHeap.print();

		
	}

	
}
