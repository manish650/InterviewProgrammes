package com.interview.panigram;

public class Panigram {
	public static void main(String[] args) {
		String input = "asdfghjklzxcvbnmwertyuiopq";
		boolean result = Panigram.searchPanigram(input);
		System.out.println(result);
	}

	public static boolean searchPanigram(String input) {
		input = input.toLowerCase();
		int[] out = new int[26];
		//boolean flag=true;
		char[] inputChar = input.toCharArray();
		int k = 0, l = 0,m=0;
		for (int i = 0; i < input.length(); i++) {
			if (inputChar[i] >= 'a' && inputChar[i] <= 'z') {
				k++;
				l = (inputChar[i] - 'a');
				if (out[l] < 1)
					out[l] = out[l] + out[l];
				else
					m=1;
			}

		}
		if(k==26&&!(m==1))
			return true;
		System.out.println("k\t"+k);
		return false;
	}

}
