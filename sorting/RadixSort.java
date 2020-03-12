package sorting;

import java.util.Arrays;

public class RadixSort {

	
	
	static int getMax(int[] arr,int n)
	{
		int max=arr[0];
		for(int i=0;i<n;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
	}
	
	static void countSort(int[] arr,int n,int exp)
	{
		int[] output=new int[n];
		int[] count=new int[10];
		for(int i=0;i<n;i++)
		{
			count[(arr[i]/exp)%10]++;
		}
		for(int i=1;i<count.length;i++)
		{
			count[i]+=count[i-1];
		}
		for(int i=arr.length-1;i>=0;i--)
		{
			output[count[(arr[i]/exp)%10]-1]=arr[i];
			count[(arr[i]/exp)%10]--;
		}
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=output[i];
		}
	}
	static void radixsort(int[] arr,int n)
	{
		int max=getMax(arr, n);
		for(int exp=1;max/exp>0;exp*=10)
		{
			countSort(arr, n, exp);
		}
	}
	
	public static void main(String[] args) {
		 int arr[] = {170, 45, 75, 90, 802, 24, 2, 66}; 
	        int n = arr.length; 
	        radixsort(arr, n); 
	        System.out.println(Arrays.toString(arr));
	    } 
	
}
