package sorting;

public class BinarySearch {
	
	
		static int binarySearch(int[] arr,int l,int r,int target)
		{
			while(l<r)
			{
				int mid=(l+r)/2;
				if(arr[mid]==target)
				{
					return mid;
				}
				else if(arr[mid]>target)
				{
					r=mid-1;
				}
				else
				{
					l=mid+1;
				}
			}
			return 0;
		}
	
	
	
	
	public static void main(String[] args) {
		  int arr[] = { 2, 3, 4, 10, 40 }; 
		  System.out.println("Index:-"+binarySearch(arr,0, arr.length-1,10));
	}
}
