 package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class JobScheduling {
	
  static class Job
	{
		char id;
		int deadline,profit;
		Job(char id,int deadline,int profit)
		{
			this.id=id;
			this.deadline=deadline;
			this.profit=profit;
		}
	}
	public static void printJobScheduling(Job[] jobs, int n) {
		
		Arrays.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				return o2.profit-o1.profit;
			}
		});
		
		TreeSet<Integer> ts=new TreeSet<>();
		for (int i = 0; i < jobs.length; i++) {
			ts.add(i);
		}
		for (int i = 0; i < jobs.length; i++) {
			Integer x=ts.floor(jobs[i].deadline-1);
			if(x!=null)
			{
				System.out.print(jobs[i].id+" ");
				ts.remove(x);
			}
		}
		
	}
	public static void main(String[] args) {
		 int n = 5; 
	        Job[] jobs = new Job[n]; 
	  
	        jobs[0] = new Job('a', 2, 100); 
	        jobs[1] = new Job('b', 1, 19); 
	        jobs[2] = new Job('c', 2, 27); 
	        jobs[3] = new Job('d', 1, 25); 
	        jobs[4] = new Job('e', 3, 15); 
	  
	        printJobScheduling(jobs, n); 
	}
	
}
