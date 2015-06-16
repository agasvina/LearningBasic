//Fibonacci.java
public class Fibonacci() {
    
    public static int Fib(int n) {
    //base case:
         if(n <=1 ) return n;
         return fib(n-1) + fib(n-2);
    }   
    
    //Dynamically solve the Fibonacci problem:
    public static int FibBetter(int n) {
        int [] fib = new int[n+2];
        fib[1] = 1;
        for(int i = 2; i < n+1; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        } 
        return fib[n];
    }
    
}
