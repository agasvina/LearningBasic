/**
 * Knapsack class.
 * This is the implementation of the famous Knapsack algorithm using
 * dynamic programming.
 * the complexity of this algorithm : O(weight.length * capacity)
 * @author luca
 * @version 1.1
 * */
public class Knapsack {
    
    public static int findMax(int [] weight, int [] value, int knapsackWeight) {
        //The subproblem is the maximum value if we take the item or we don't take the item.
        //let i represent the number of item
        //let j represent the weight
        //create a matrix[weight.length+1][knapsackWeight+1] = dp[i][j];
        //initialize dp[0][j] = 0; dp[i][0] = 0;
        //dp[i][j] = Max( dp[i-1][j],  ( value[i-1] + dp[i-1][j-w[i-1]] ... if j >= w[i-1]
        //the maximum value is dp[weight.length][knapsackWeight+1]
        
        int [][] dp = new int[weight.length+1][knapsackWeight+1];
        //chosen is used to keep track weather a certain item is taken or not
        // 0 denotes the current item is not  taken,
        // 1 denotes the current item is taken
        int [][] chosen = new int[weight.length+1][knapsackWeight+1];
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(j - weight[i-1] >= 0) {
                    if(dp[i-1][j] > (value[i-1] + dp[i-1][j-weight[i-1]])) {
                        dp[i][j] = dp[i-1][j];
                        chosen[i][j] = 0;
                    } else {
                        dp[i][j] = value[i-1] + dp[i-1][j-weight[i-1]];
                        chosen[i][j] = 1;
                    }
                } else {
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        //Print the chosen item using the DP chaining.
        print(chosen, weight, weight.length, knapsackWeight);
        return dp[weight.length][knapsackWeight];
    }
    
    public static void main(String [] args) {
        int [] weight = {3,2,4,1};
        int [] value = {5,4,7,4};
        System.out.println(findMax(weight, value, 5));
    }
    
    //print the chosen item recursively
    public static void print(int [][] chosen, int [] weight, int i, int j) {
        if(i <=0 || j <= 0) return;
        if(chosen[i][j] == 0) {
            print(chosen,weight,i-1,j);
        } else {
            System.out.println("item:" + i + " with weight: " + weight[i-1] + " is taken" );
            print(chosen,weight,i-1,j-weight[i-1]);
        }
    }
    
    
}
