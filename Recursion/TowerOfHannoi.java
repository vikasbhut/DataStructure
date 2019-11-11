package Recursion;

public class TowerOfHannoi {

	static void towerOfHanoi(int n,char from_rod,char to_rod,char aux_rod)
	{
		if(n==1)
		{
			System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
			return;
		}
		else if (n>1) {
			towerOfHanoi(n-1, from_rod, aux_rod,to_rod);
	        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
	        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
		}
	}
	public static void main(String[] args) {
		
		towerOfHanoi(2,'x','y','z' );
	}
}
