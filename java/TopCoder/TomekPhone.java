import java.util.*;

public class TomekPhone {
	public static void main(String [] args) {
		int [] f = {100,1000,1,10};
		int [] k = {50};
		System.out.println(minKeystrokes(f, k));
	}
	
	
	public static int minKeystrokes(int [] f, int [] k) {
		Arrays.sort(f);
		Arrays.sort(k);
		int max = k[k.length-1];
		int [] total = new int[max+1];
		int sum = 0;
		for(int i = 0; i < k.length; i++) {
			total[k[i]]++;
			sum += k[i];
		}
		int maxRep = total[max];
		for(int i = max-1; i >= 0; i--) {
			maxRep = total[i] +maxRep;
			total[i] = maxRep;
		}
		if(f.length > sum) return -1;

		int idx = 1;
		int tot = 0;
		for(int i = 0; i < f.length; i++) {
			tot += f[f.length-i-1]*idx;
			if(idx > total.length-1) break;
			total[idx]--;
			if(total[idx] == 0) {
				idx++;
			}
		}
		return tot;
			
	}


}
