package sorting;

public class BubbleSort {

	static void sort(int[] arr)
	{
		boolean swapped;
		for(int i=0;i<arr.length-1;i++)
		{
			swapped=false;
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			if(swapped==false)
			{
				break;
			}
			
		}
	}
	
		public static void main(String[] args) {
			
			int[] arr= {10,20,30,50,40};
			sort(arr);
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]+" ");
			}
		}
	
}
