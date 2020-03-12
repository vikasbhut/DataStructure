package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

	public static void bucketsort(int[] arr, int noOfBuckets) {

		LinkedList<Integer>[] buckets = new LinkedList[noOfBuckets];
		for (int i = 0; i < noOfBuckets; i++) {
			buckets[i] = new LinkedList<>();
		}

		for (int num : arr) {

			buckets[hash(num)].add(num);
		}
		
		for (LinkedList<Integer> linkedList : buckets) {
			Collections.sort(linkedList);
		}
		
		int i=0;
		for (LinkedList<Integer> linkedList : buckets) {
			for(int num:linkedList)
			{
				arr[i++]=num;
			}
		}

	}

	public static int hash(int num) {
		return num / 10;
	}

	public static void main(String[] args) {
		int[] intArr = { 47, 85, 10, 45, 16, 34, 67, 80, 34, 4, 0, 99 };
		// int[] intArr = {21,11,33,70,5,25,65,55};
		System.out.println("Original array- " + Arrays.toString(intArr));
		bucketsort(intArr, 10);
		System.out.println("Sorted array after bucket sort- " + Arrays.toString(intArr));
	}
}
