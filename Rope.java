package com.manish.app;

public class Rope {
	static int a[] = { 4, 3, 2, 6 };
	static int size = a.length;

	public static void main(String[] args) {

		System.out.println(find(a, a.length));
	}
	static int find(int[] a, int l) {
		for (int i = l / 2 - 1; i >= 0; i--) {
			minHeapFy(i, a, l);
		}
		return cost(a, l);
	}

	private static int cost(int[] a, int l) {
		int cost = 0;
		while (size != 1) {
			int min = exractMin(a, size);
			int sec_min = exractMin(a, size);

			cost += (min + sec_min);
			// i was not able to thing to pass a parameter min+sec_min
			insert(min + sec_min);
		}
		return cost;
	}

	private static void insert(int cost) {
		if (size > a.length) {
			System.out.println("overflow");
			return;
		}
		size++;
		int i = size - 1;
		a[i] = cost;
		// i didnt think about when i=0 we haveto stop the while loop
		// i didnt think about parent can be more than chid in min heap, so we have to
		// fix it.
		// at the end I have to change "i" from its parent index
		while (i != 0 && a[(i - 1) / 2] > a[i]) {
			int temp = a[(i - 1) / 2];
			a[(i - 1) / 2] = a[i];
			a[i] = temp;
			i = (i - 1) / 2;
		}

	}

	private static int exractMin(int[] a, int size) {
		int root = 0;
		if (size == 1) {
			size--;
			return a[0];
		}
		root = a[0];
		a[0] = a[size - 1];
		size--;
		minHeapFy(0, a, size);
		System.out.println(size);
		return root;
	}

	static void minHeapFy(int i, int[] a, int size) {
		int minElementIndex = i;
		int li = 2 * i + 1;
		int ri = 2 * i + 2;
		if (li < size && a[li] < a[i]) {
			minElementIndex = li;
		}
		if (ri < size && a[ri] < a[minElementIndex]) {
			minElementIndex = ri;
		}
		if (minElementIndex != i) {
			int temp = a[i];
			a[i] = a[minElementIndex];
			a[minElementIndex] = temp;
			minHeapFy(minElementIndex, a, size);
		}
	}
}