import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LongestUniqueSubstring {
	
	public static void longestSubstring(String N, int ctr) {
		Map<Character, Integer> letter = new HashMap<Character, Integer>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		int startMax=0;
		int start = 0;
		int maxSub=1;
		int flag = 0;
		index.add(0);
		for(int i = 0; i < N.length(); i++) {
			letter.put(N.charAt(i),1);
			if(N.charAt(flag) != N.charAt(i)) {
				flag =i;
				index.add(flag);
			} 
			if(letter.size() > ctr) {
				letter.clear();
				int toAdd = index.size() - ctr;
				int toDec = index.get(toAdd);
				//re-populate the set (ctr) times:
				Character last = null;
				for(int j = index.size()-1; j >=0; j--) {
					last = N.charAt(index.get(j));
					System.out.println(last);
					letter.put(last,1);
					if(letter.size() > ctr) {
						toDec = index.get(j);
						letter.remove(last);
						break;
					}
					
					//if(letter.size() == ctr) break;
				}
				int length = i - toDec;
				if(maxSub < length) {
					maxSub = length;
					startMax = toDec;
				}
			}	
		}
		System.out.println(Arrays.toString(index.toArray()));
		System.out.println(N.substring(startMax, startMax+ maxSub));
		
		}
	
	
	public static void main(String [] args) {
		longestSubstring("ddddddddddddddddabbcacaaddd", 3);
		int y = 0;
	}

}

