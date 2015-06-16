/*
	As if we don’t have any other interesting stuffs to do… In this post, 
	I talk about another interesting example of another application of the  
	“Dynamic” Programming. By now, you should be familiar with the idea of Dynamic programming.
	That’s rite: solve the smaller problem and update. 
	This time, I will talk about a solution to find the longest common substring.
	Yup! not a subsequence. For example,
	s1 = “aabbc”
	s2 = “dbbca”
	
	the longest substring is bbc. Here how you solve it. 
	Suppose we have i to denote the value from 0 to s1.length and j form 0 to s2.length.
	We need a matrix C[i][j] to keep the value of the  substring length and 
	max to keep the value of longest substring. And how we populate that? 
	
	Simple, 
	if( s1[i-1] == s2[j-1] ) 
	C[i][j] = C[i-1][j-1] +1….  update max.
	otherwise C[i][j] = 0
	Why 0?? Because if s1[i] != s2[i] it’s not a valid substring. 
	Simple.

 * 
 * */
public class LongestCommonSubstring {

	public static String  lcs(String s1, String s2) {
		int longest[][] = new int[s1.length()+1][s2.length()+1];
		int iLong = 0;
		int maxSub = 1;
		for(int i = 1; i < s1.length()+1; i++) {
			for(int j = 1; j < s2.length()+1; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					longest[i][j] = longest[i-1][j-1]+1;
					if(longest[i][j] > maxSub) {
						maxSub = longest[i][j];
						iLong = i;
					}
				} else {
					longest[i][j] = 0;
				}
			}
			
		}
		System.out.println(maxSub);
		return s1.substring(iLong-maxSub, iLong);
	}

	public static void main(String [] args) {
		String s1 = "aabbbcc";
	    String s2 = "bbbc";
	    System.out.println(lcs(s1,s2));
	}
	
}

