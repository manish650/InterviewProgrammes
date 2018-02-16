package com.interview.panigram;

public class Panigram {
	public static void main(String[] args) {
		String input="abfdhjklfeis";
		boolean result=Panigram.searchPanigram(input);
		System.out.println(result);
	}
	public static boolean searchPanigram(String input) {
		input=input.toLowerCase();
		int[] out=new int[26];
		char[] inputChar=input.toCharArray();
		for(int i=0;i<input.length();i++)
		{
			if(inputChar[i]>='a'&&inputChar[i]<='z')
			{
				if(out[(inputChar[i]-'a')]<1) {
				++out[(inputChar[i]-'a')];
				}
			    else 
			    	return false; 
			}
			
		}
		return true;
	}

}
