package sorting;

import java.util.Arrays;

public class SelectionSort {

	
	static void sort(int[] arr)
	{
		int i,j,min;
		for(i=0;i<arr.length-1;i++)
		{
			min=i;
			for(j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[min])
				{
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
	}
	
	
	public static void main(String[] args) {
		 int arr[] = {64,25,12,22,11}; 
		 sort(arr);
		 System.out.println(Arrays.toString(arr));
		
	}
}
