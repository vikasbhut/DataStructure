package greedy;

import java.util.PriorityQueue;

public class OptimalMergePatterns {

	public static int minComputation(int size, int[] files) {
		
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		for (int i = 0; i < size; i++) {
			minHeap.add(files[i]);
		}
		
		int noOfMovmentOfRecord=0;
		while(minHeap.size()>1)
		{
			int temp=minHeap.poll()+minHeap.poll();
			noOfMovmentOfRecord+=temp;
			minHeap.add(temp);
		}
		return noOfMovmentOfRecord;
	} 
	public static void main(String[] args) 
    { 
  
        // no of files 
        int size = 3; 
  
        // 6 files with their sizes 
        int files[] = new int[] {10,20,30}; 
  
        // total no of computations 
        // do be done final answer 
        System.out.println("Minimum Computations = "
                           + minComputation(size, files)); 
    }

	
}
