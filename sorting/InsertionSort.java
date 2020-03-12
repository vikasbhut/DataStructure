package sorting;

public class InsertionSort {

	
	
	static void insertionSort(int[] arr)
	{
		int n=arr.length;
		for(int j=1;j<n;j++)
		{
			int key=arr[j];
			int i=j-1;
			while(i>=0&&arr[i]>key)
			{
				arr[i+1]=arr[i];
				i--;
			}
			arr[i+1]=key;
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr= {8,7,6,5,4,3,2,1};
		insertionSort(arr);
		for(int i=0;i<arr.length;i++)
		{
		 System.out.println(arr[i]+" ");
		}
	}	
	
}
