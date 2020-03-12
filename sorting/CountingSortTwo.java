package sorting;

import java.util.Arrays;

public class CountingSortTwo {

	
	static void sort(char[] arr)
	{
		int[] output=new int[arr.length];
		int[] count=new int[256];
		
		for(int i=0;i<arr.length;i++)
		{
			count[arr[i]]++;
		}
		
		for(int i=1;i<count.length;i++)
		{
			count[i]+=count[i-1];
		}
		for(int i=arr.length-1;i>=0;i--)
		{
			output[count[arr[i]]-1]=arr[i];
			count[arr[i]]--;
		}
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(char) output[i];
		}

	}
	
	public static void main(String[] args) {
		 char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o', 
                 'r', 'g', 'e', 'e', 'k', 's'
                 }; 
		sort(arr); 
		System.out.println(Arrays.toString(arr));
	}
}
