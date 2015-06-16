import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LongestIncrement {
    
    public static void main(String [] args) {
        int []  arr = {3, -1,5, 4, 9, 8, 8, 8, 8, 78, 89, 600, 890, 2};
        List(arr);
    }
    
    public static void List(int [] a) {
        if(a.length == 0) return;
        if(a.length <= 1) System.out.println(a[0]);
        Map <Integer, ArrayList<Integer>> path = new HashMap<>();
        int [] maxValue = new int[a.length+1];
        for(int i = 0; i < maxValue.length;i++) maxValue[i] = -1;
        
        int currentMax = 1;
        path.put(1, new ArrayList<>());
        path.get(1).add(a[0]);
        currentMax =1;
        maxValue[currentMax] = 0;
        
        
        for(int i = 1; i < a.length; i++) {
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
                    if(path.get(total-1) != null) {
                        path.put(total, new ArrayList<Integer>(path.get(total-1)));
                        path.get(total).add(a[i]);
                    } else {
                        path.put(total, new ArrayList<>());
                        path.get(total).add(a[0]);
                    }
                }
                
            } else { //max/valu[total] = -1
                maxValue[total] = i;
                if(path.get(total-1) != null) {
                    path.put(total, new ArrayList<Integer>(path.get(total-1)));
                    path.get(total).add(a[i]);
                } else {
                    path.put(total, new ArrayList<>());
                    path.get(total).add(a[0]);
                }
            }
            currentMax = Math.max(currentMax, total);
        }//end of else
        System.out.println(currentMax);
        System.out.println(Arrays.toString(path.get(currentMax).toArray()));
        
    }
    
    
    
}



