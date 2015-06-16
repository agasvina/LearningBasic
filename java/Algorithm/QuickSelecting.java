import java.util.ArrayList;


public class QuickSelecting {

	public static void main(String[] args) {
		int [] b = {8,10,1,2,5,5,5,5,5,5,5,5,5};
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i : b) {
			a.add(i);
		}
		System.out.println(quickSelecting(a, 5));
	}
	
	public static int quickSelecting(ArrayList<Integer>a, int n) {
		ArrayList<Integer>  left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		int l = 0;
		int r = a.size()-1;
		int pivot = a.get((l+r)/2);
		System.out.println(pivot);
		
		//divide the element of array a into left and right.
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i) < pivot)  {
				left.add(a.get(i));
			} else if(a.get(i) > pivot) {
				right.add(a.get(i));
			} else {
				//do nothing
			}

		}
		System.out.println(pivot + " " + left.size());
		//finding n-th smallest element
		if(n <= left.size()) {
			return quickSelecting(left, n);
		} else if(n > (a.size() - right.size())) {
			n = n -(a.size() - right.size());
			return quickSelecting(right, n);
		} else {
			return pivot;
		}
	
		
	}
}

