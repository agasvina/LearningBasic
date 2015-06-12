import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class LongestIncreasingSubstring {

	public static void main(String [] args) {
		int []  arr = {3, 5, 4, 9, 2, 1, 4, 8, 19, 8,8,8, 1};
		List(arr);
	}
	
	public static void List(int [] a) {
		Map <Integer, ArrayList<Integer>> path = new HashMap<>();
		int [] maxValue = new int[a.length+1];
		for(int i = 0; i < maxValue.length;i++) maxValue[i] = -1;
		int currentMax = -1;
		for(int i = 0; i < a.length; i++) {
			if(currentMax == -1) {
				path.put(1, new ArrayList<Integer>());
				path.get(1).add(a[i]);
				currentMax =1;
				maxValue[1] = i;
			} else {
				int total = 1;
				for(int j=currentMax; j > 0; j--) {
					if(a[maxValue[j]] < a[i]) {
						total = j+1;
						break;
					}
				}
				if(maxValue[total] != -1) {
					if(a[i] < a[maxValue[total]]) {
						maxValue[total]= i;
						//update path!!
						if(path.get(total) == null) {
							if(path.get(total-1) != null) {
							path.put(total, path.get(total-1));
							path.get(total).add(a[i]);
							} else {
								path.put(total, new ArrayList<Integer>());
								path.get(total).add(a[i]);
							}
							
						} 
				}
				} else {
					maxValue[total] = i;
					if(path.get(total-1) != null) {
						path.put(total, path.get(total-1));
						path.get(total).add(a[i]);
						} else {
							path.put(total, new ArrayList<Integer>());
							path.get(total).add(a[i]);
						}
				}
				currentMax = Math.max(currentMax, total);
			}//end of else
		}
		System.out.println(currentMax);
		System.out.println(Arrays.toString(path.get(currentMax).toArray()));
	}
	
}

