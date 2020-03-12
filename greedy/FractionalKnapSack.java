package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {

	static class ItemValue {
		double wt,val;
		Double cost;
		public ItemValue(double wt,double val) {
			this.wt=wt;
			this.val=val;
			cost=new Double(val/wt);
		}
	}

	public static double getMaxValue(int[] wt, int[] val, int capacity) {
		ItemValue[] itemValues=new ItemValue[wt.length];
		for (int i = 0; i < itemValues.length; i++) {
			itemValues[i]=new ItemValue(wt[i], val[i]);
		}
		Arrays.sort(itemValues,new Comparator<ItemValue>() {

			@Override
			public int compare(ItemValue o1, ItemValue o2) {
				return o2.cost.compareTo(o1.cost);
			}
		});
		
		int totalProfit=0;
		for (ItemValue itemValue : itemValues) {
			int  w=(int) itemValue.wt;
			int v=(int) itemValue.val;
			if(capacity-w>=0)
			{
				capacity-=w;
				totalProfit+=v;
			}
			else
			{
				double fraction=(double)capacity/(double)w;
				totalProfit+=v*fraction;
				break;
			}
		}
		return totalProfit;
	
	}

	public static void main(String[] args) {

		int[] wt = {1,4,5,3,3}; 
        int[] val = {2, 28, 25, 18,9}; 
        int capacity = 15; 

		double maxValue = getMaxValue(wt, val, capacity);
		System.out.println("Maximum value we can obtain = " + maxValue);

		
		
	}

}
