import java.util.Arrays;


public class Leader {

	public static void main(String [] args){
		int [] test = {1,8,8,5,8,8,7};
		System.out.println(findingLeader(test));
		System.out.println(findingLeaderStack(test));
		
	}
	
	//lame solution of finding leader (using sorting); 
	//Total complexity: O(NLogN) due to the sorting.
	//A leader of the element the dominant element of the array
	//(i.e. occurs more than half of the size of the array)
	public static int findingLeader(int [] elements) {
		Arrays.sort(elements);
		int longest = 1;
		int leader = elements[0];
		int counter = 1;
		for(int i = 1; i < elements.length; i++){
			if(elements[i-1] == elements[i]) {
				counter++;
			} else {
				if(counter > longest) {
					longest = counter;
					leader = elements[i-1];
				}
				counter=1;
			}
		}
		//checking the last element:
		if(counter > longest) {
			longest = counter;
			leader = elements[elements.length-1];
		}
		if(longest > elements.length/2) return leader;
		return -1;
	}
	
	//Cool algorithm using stack implementation.
	public static int findingLeaderStack(int [] elements) {
		//First assumption, leader is always the first element.
		int value = elements[0];
		int size = 1;
		for(int i = 1; i < elements.length; i++) {
			if(size == 0) {
				value = elements[i];
				size = 1;
			} else {
				if(elements[i] == value) {
					size++;
				} else {
					size--;
				}
			}
		}//eofi
		int candidate = value;
		int counter = 0;
		for(int i = 0; i < elements.length;i++) {
			if(candidate == elements[i]) counter++;
		}
		if(counter > elements.length/2) return candidate;
		return -1;
	}
	
}



