package sorting;

public class MergeSort {


	static void merge(int[] arr,int p,int q,int r)
	{
		
		int n1=q-p+1;
		int n2=r-q;
			
		int[] L=new int[n1];
		int[] R=new int[n2];
			
		for(int i=0;i<n1;i++)
		{
			L[i]=arr[i+p];
		}
		for(int j=0;j<n2;j++)
		{
			R[j]=arr[q+j+1];
		}
		
		int i=0,j=0,k=p;
		
		while(i<n1&&j<n2)
		{
			if(L[i]<R[j])
			{
				arr[k]=L[i];
				i++;
			}
			else
			{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1)
		{
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			arr[k]=R[j];
			j++;
			k++;
		}
	}
	
	static void sort(int[] arr,int p,int r)
	{
		if(p<r)
		{
			int q=(p+r)/2;
			sort(arr, p, q);
			sort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
   
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	
	public static void main(String[] args) {
		int[] arr= {11, 12, 13, 5, 6, 7};
		sort(arr, 0, arr.length-1);
		printArray(arr);
	
	}
}
