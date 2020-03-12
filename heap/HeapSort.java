
package heap;

public class HeapSort {

  void heapify(int[] arr,int size,int i)
	{
	  int largest=i;
	  int l=2*i+1;
	  int r=2*i+2;
	  if(l<size&&arr[l]>arr[largest])
	  {
		  largest=l;
	  }
	  if(r<size&&arr[r]>arr[largest])
	  {
		  largest=r;
	  }
	  if(largest!=i)
	  {
		  int temp=arr[i];
		  arr[i]=arr[largest];
		  arr[largest]=temp;
		  heapify(arr, size,largest);
	  }
	  
	  
	}
  
  void sort(int[] arr)
  {
	int l=arr.length;
	for(int i=(l/2)-1;i>=0;i--)
	{
		heapify(arr,l, i);
	}
	for(int i=l-1;i>=1;i--)
	{
		int temp=arr[0];
		arr[0]=arr[i];
		arr[i]=temp;
		heapify(arr,i,0);
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
