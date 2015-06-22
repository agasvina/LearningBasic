import java.util.ArrayList;
import java.util.Arrays;


public class MergeSort {
    public static void main(String [] args) {
        int [] test = {1,7,9,2,6,5,3};
        ArrayList<Integer> dummy = new ArrayList<>();
        for(int i : test) {
            dummy.add(i);
        }
        sort(dummy);
        System.out.println(Arrays.toString(dummy.toArray()));
    }
    
    
    public static void sort(ArrayList<Integer> arr) {
        mergesort(arr);
    }
    
    public static void mergesort(ArrayList<Integer> arr) {
        if(arr.size() <2) return;
        ArrayList<Integer> left =new ArrayList<>(arr.subList(0, arr.size()/2));
        ArrayList<Integer> right =new ArrayList<>(arr.subList(arr.size()/2, arr.size()));
        
        mergesort(left);
        mergesort(right);
        //merge all:
        merging(arr, left, right);
    }
    
    
    private static void merging(ArrayList<Integer> arr,
                                ArrayList<Integer> left, ArrayList<Integer> right) {
        arr.clear();
        while(!left.isEmpty() && !right.isEmpty()) {
            if(left.get(0) < right.get(0)) {
                arr.add(left.remove(0));
            } else {
                arr.add(right.remove(0));
            }
        }
        
        while(!left.isEmpty()) {
            arr.add(left.remove(0));
        }
        while(!right.isEmpty()) {
            arr.add(right.remove(0));
        }
    }
    
    
}
