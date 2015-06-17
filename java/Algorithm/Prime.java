import java.util.ArrayList;
import java.util.Arrays;
 
/*
"How do you find the number of divisor for this particular number n?"
"How to check if a number is a prime number?"
"How do you find the find all the prime numbers that is less x?"

For the first and second questions:
One of the solutions which takes a complexity of O(N) is as follow:
	iterate i  from 1 to n, 
	modulo n by  i, if the result is 0 then i is the divisor of n

However, there is a unique solution which only take O(n^0.5)..
if a number n is divide by i, it’s also can be divided by n/i.
In that case we can simply check the number from 1 to the root of n (n^0.5) 
because  (n^0.5) * (n^0.5) = n. Therefore, if you do the modulo 
operation of n by i and the result is 0, you have two divisor for n. 
*/
public class Prime {
 
        public static ArrayList<Integer> getDivisor(int n) {
                ArrayList<Integer> results = new ArrayList<Integer>();
                int div = 1;
                while(div * div <= n) {
                        if(n%div == 0) {
                                results.add(div);
                                if(div != n/div) {
                                        results.add(n/div);
                                }
                        }
                        div++;
                }
                return results;
        }
       
        //checking whether the number is prime is similar, 
        //during the iteration if the n is divisible by div, we can conclude that n is not a prime number.
        public static boolean isPrime(int n) {
        	//we start from 2 because 1 is not as prime number and all numbers is divisible by 1
        	int div = 2;
        	while(div * div <= n) {
        		if(n%div == 0) {
        			return false;
        		}
        		div++;
        	}
        	return true;
        }
        
        //finding a prime number using the same principle as above. 
        public static ArrayList<Integer> findingPrime(int n) {
        	boolean [] notPrime = new boolean[n+1];
        	notPrime[0] = true;
        	notPrime[0] = true;
        	//because prime number is started from 2 
        	int div = 2;
        	while (div * div <= n) {
        		//we only interest in the prime here, because the not prime number and it's multiplication 
        		//has been updated by their divisor. 
        		if(!notPrime[div]) {
        			int k = div*div;
        			while(k<= n) {
        				notPrime[k] = true;
        				//check the multiplication of div to n; ex from 2 to 18 --> 2,4,6,....,18
        				k+=div;
        			}
        		}
        	div++;
        	}
        	
        	ArrayList<Integer> results = new ArrayList<Integer>();
        	for(int i = 0; i < notPrime.length; i++) {
        		if(!notPrime[i]) {
        			results.add(i);
        		}
        	}
        	
        	return results;
        }
        
        
        public static void main(String [] args) {
               System.out.println(isPrime(13));
               System.out.println(Arrays.toString(findingPrime(13).toArray()));
        }
       
}
