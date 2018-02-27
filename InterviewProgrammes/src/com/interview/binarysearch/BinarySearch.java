package com.interview.binarysearch;

public class BinarySearch {

	private static int binarySearch(int[] arr, int start, int end, int element) {
		int mid = start + (end - start) / 2;
		if (start > end) {
			return -1;
		}
		if (arr[mid] == element) {
			return mid;
		} else if (arr[mid] < element) {
			start = mid + 1;
			return binarySearch(arr, start, end, element);
		} else {
			end = mid - 1;
			return binarySearch(arr, start, end, element);
		}
		//return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 9,10,20,55,99 };
		int length = arr.length;
		int start = 0;
		int elements = 1;
		int output=binarySearch(arr, start, length - 1, elements);
		if(output==-1)
			System.out.println("Item not Exist");
		else     //7550198450
       System.out.println("Index\t"+output+"\nOutput\t"+arr[output]);
	}

}
