import java.math.*;
//We use the BigInteger class to avoid the problem of string overflow. 
public class ObtainingDigitK {
    public static int minNumberToAdd(String oN, int k) {
        int end = (int) oN.charAt(oN.length()-1) - 48;
        int kEdit = k;
        if(end > k ) kEdit+=10;
        int minTemp =  kEdit-end;
        for(int i = 0; i < minTemp; i++) {
            BigInteger number = new BigInteger(oN);
            BigInteger Result =  number.add(new BigInteger(i+""));
            for(int j = 0; j < Result.toString().length(); j++) {
                int temp = (int) Result.toString().charAt(j) - 48;
                if((int) Result.toString().charAt(j) - 48 == k) return i;
            }
        }
        return minTemp;
    }
}