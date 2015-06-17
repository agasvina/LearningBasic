import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is created to find the tuple that is less than n in an array. 
 * Here, we are interested in finding the solution of this array:
 * Given an array A of n integers and a target value S, give a 3-tuple from A that sums to S?
 * The algorithm is taken from stack overflow.
 * @version 1.1
 * @author as362
 * */
public class Tuple3 {

	public static void main(String [] args) {
		int [] elem = {1,5,8,9,2,3};
		ArrayList<int []> tuple = findTuple3(elem, 11);
		
		for(int i = 0; i < tuple.size(); i++) {
			System.out.println(Arrays.toString(tuple.get(i)));
		}
	}
	
	public static ArrayList<int[]> findTuple3(int [] elements, int bound) {
		ArrayList<int[]> results = new ArrayList<int []>();
		//we first sorted the element:
		//then we iterate through the element
		Arrays.sort(elements);
		for(int e1 =0; e1 < elements.length-1; e1++) {
			int e2; //e2 is the middle element
			int e3 = elements.length-1; //e3 is the last elements.
			for(e2 = e1+1; e2 < elements.length-2; e2++) {
			int temp = e3;
				while(e2 < e3 && e2 >= 0 && e2 < elements.length && e3 >=0 && e3 <elements.length) {
					if(elements[e1] + elements[e2] + elements[e3] <= bound) {
						//this is the tuple we want:
						int [] temps = {elements[e1],elements[e2],elements[e3]};
						results.add(temps);
					}
					//we will reset the value of the thrid element. 
					//based on the tuple sum, because int the next iteration the elements[e2] will be bigger,
					//so we don't need to check the elements[e3] that caused the sum more than the bound. 
					if(elements[e1] + elements[e2] + elements[e3] > bound) {
						temp = e3-1;
					}
						e3--;
			}
			e3 = temp;
			}
		}//eof
			
			
		
		return results;	
	}
	

}

