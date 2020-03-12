package heap;

public class Demo {

	
	void maxHeapify(int[] arr,int size,int i)
	{
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		
		if(l<size&&arr[l]>largest)
			largest=l;
		if(r<size&&arr[r]>largest)
			largest=r;
		if(largest!=i)
		{
			int temp=arr[largest];
			arr[largest]=arr[i];
			arr[i]=temp;
		}
	   maxHeapify(arr,size,largest);
	}
	
	void sort(int[] arr)
	{
		for(int i=(arr.length/2)-1;i>=0;i--)
		{
			maxHeapify(arr,arr.length, i);
		}
		
		for(int i=arr.length-1;i>=1;i--)
		{
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			maxHeapify(arr,i, 0);
		}
		
		
	}
	static void printArray(int arr[]) 
	  { 
	      int n = arr.length; 
	      for (int i=0; i<n; ++i) 
	          System.out.print(arr[i]+" "); 
	      System.out.println(); 
	  } 
	
	public static void main(String args[]) 
	  { 
		int arr[] = {12, 11, 13, 5, 6, 7}; 
	      int n = arr.length; 

	      HeapSort ob = new HeapSort(); 
	      ob.sort(arr); 

	      System.out.println("Sorted array is"); 
	      printArray(arr); 
	  }

	
}
