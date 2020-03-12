package sorting;

public class QuickSort {

	
	static int  partition(int[] arr,int p,int r)
	{
		int x=arr[r];
		int i=p-1;
		for(int j=p;j<r;j++)
		{
			if(arr[j]<x)
			{
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=temp;
		return i+1;
	}
	
	
	static void sort(int[] arr,int p,int r)
	{
		if(p<r)
		{
			int q=partition(arr, p, r);
			sort(arr, p, q-1);
			sort(arr, q+1, r);
		}
	}
	public static void main(String[] args) {
		 int arr[] = {10, 7, 8, 9, 1, 5}; 
	     int n = arr.length; 
	
	     sort(arr,0,n-1);
	     
	     for(int i=0;i<n;i++)
	     {
	    	 System.out.print(arr[i]+" ");
	     }
	}
	
}
