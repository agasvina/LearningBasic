import java.util.Arrays;


public class QuickSort {
    
    public static void main(String [] args) {
        int [] test = {1,7,9,2,6,5,3};
        sort(test);
        System.out.println(Arrays.toString(test));
    }
    
    public static void sort(int [] elements) {
        quicksort(elements, 0, elements.length-1);
    }
    
    
    public static void quicksort(int [] elements, int low, int upper) {
        int l = low;
        int r = upper;
        int pivot = elements[(l+r)/2];
        
        while(l<= r) {
            while(elements[l] < pivot) {
                l++;
            }
            while(elements[r] > pivot) {
                r--;
            }
            if(l<=r) {
                swap(elements, l, r);
                l++;
                r--;
            }
            
        }
        
        if(l < upper) {
            quicksort(elements, l, upper);
        } 
        if(r > low) {
            quicksort(elements, low, r);
        }
        
        
    }
    
    private static void swap(int[] elements, int l, int r) {
        int temp = elements[r];
        elements[r] = elements[l];
        elements[l] = temp;
    }
    
}
