import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains the method finding the maximum 
 * sum of the sub array. The implementation of this
 * algorithm is based on Dynamic programming technique.
 * Remember, the DP principle is solving the smaller problem first, 
 * find the optimal solution gradually until the whole problem 
 * is solve. 
 * Assume we has this following array:
 * 4,-6,3,5,-2,4,-1
 * We create some variables to keep track the value of the sum to the ending (maxEnding).
 * and the overall maximum slice (maxSlice), 
 * We iterate the element from 0 to the array.length
 * in each iteration (i)  we update both maxEnding and maxSlice value:
 * 		nb:if the sum is less than 0 we neglect the current slice and set maxEnding to 0
 *  	maxEnding = max(maxEnding + array[i], 0);  
 * 		maxSlice = max(maxEnding, maxSlice);
 * 
 * 
 * @author luca
 * @version 1.1
 * */
public class MaxSliceSum {

	public static void main(String [] args) {
		int [] elements =  {4,-6,3,5,-2,4,-1};
		System.out.println(Arrays.toString(maxSlice(elements).toArray()));
	}
	
	public static ArrayList<Integer> maxSlice(int[] elements) {
		int maxEnding = 0;
		int maxSlice = 0;
		int idx = -1;
		for(int i = 0; i < elements.length; i++) {
			//if maxEnding is less than 0, we consider to start over.
			maxEnding = Math.max(maxEnding + elements[i], 0);
			if(maxSlice < maxEnding) {
				maxSlice = maxEnding;
				//idx is updated with the last element which produce the maxSlice
				//this idx is used for tracing back.
				idx = i;
			} 
		}//eofi
		if(idx == -1) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		//retrace to find the element which make up the maximumSlice:
		for(int i = idx; i >=0; i--) {
			maxSlice -= elements[i];
			//add the number to the first element of the array.
			result.add(0,elements[i]);
			if(maxSlice == 0) {
				break;
			}
		}
		return result;
	}
	
}

