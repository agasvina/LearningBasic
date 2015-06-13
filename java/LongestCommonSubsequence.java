import java.util.ArrayList;


public class LongestCommonSubsequence {

	public static void main(String [] args) {
		char [] a = {'A', 'C', 'C','A'};
		char [] b = {'C', 'C', 'G', 'A'};
		System.out.println(longestSubsequence(a, b));
	}
	
	public static void print(int [][] storeValue, char[] e1, int i, int j, ArrayList<Character> store) {
		if(i <=0 || j<= 0) return;
		if(storeValue[i][j] == 0) {
			//because we only print the one with the same value,
			store.add(0,e1[i-1]);
			print(storeValue, e1, i-1,j-1, store);
		} else if(storeValue[i][j] == 1) {
			print(storeValue, e1, i-1,j, store);
		} else if(storeValue[i][j] == 2) {
			print(storeValue, e1,  i,j-1, store);
		}
	}
	
	
	public static  char[] longestSubsequence(char[] e1, char[] e2) {
		int [][] longestValue = new int[e1.length+1][e2.length+1]; 
		int [][] storeValue = new int[e1.length+1][e2.length+1]; //0: same, 1: from e1, 2: from e2
		
		for(int i = 1; i < longestValue.length; i++) {
			for(int j = 1; j < longestValue[0].length; j++) {
				if(e1[i-1] != e2[j-1]) {
					if(longestValue[i-1][j] > longestValue[i][j-1]) {
						storeValue[i][j] = 1;
					} else {
						storeValue[i][j] = 2;
					}
					longestValue[i][j] = Math.max(longestValue[i-1][j], longestValue[i][j-1]);
					
				} else {
					longestValue[i][j] = longestValue[i-1][j-1]+1; //previous value +1
					storeValue[i][j] =0;
				}
				
			}
		}
		//Finding the subsequence using storeValue
		ArrayList<Character> result = new ArrayList<Character>();
		print(storeValue,e1,e1.length, e2.length, result);
		char[] res = new char[result.size()];
		for(int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}
		
		System.out.println(longestValue[e1.length][e2.length]);
		return res;
		
	}
	
}

