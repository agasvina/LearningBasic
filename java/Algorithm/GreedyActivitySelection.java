import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is the implementation of the Activity-Selection problem
 * based on the famous Algorithm book from MIT.
 * @author luca
 * @version 1.1
 * */
public class GreedyActivitySelection {

	//greedily select the activity. 
	//assume the activity is sorted based on the finish time. 
	public static void greedyActivity(int [] start, int [] finish) {
		ArrayList<Integer> activityStartList = new ArrayList<Integer>();
		activityStartList.add(0);
		//iterate through the rest of the list
		for(int i = 1; i < start.length; i++) {
			if(start[i] >= finish[activityStartList.get(activityStartList.size()-1)]) {
				activityStartList.add(i);
			}
			
		}
		
		//print the activity:
		System.out.println(Arrays.toString(activityStartList.toArray()));
		
	}
	
	public static void main(String [] args) {
		int [] si = {1,3,0,5,3,5,6,8,8,2,12};
		int [] fi = {4,5,6,7,9,9,10,11,12,14,16};
		greedyActivity(si, fi);
		
	}
	
	
}

