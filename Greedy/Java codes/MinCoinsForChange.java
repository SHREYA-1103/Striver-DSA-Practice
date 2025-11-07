// -------------------------------- Ques --------------------------------
// Given a coins array stating the various denomination of coins available and a value, v. Assuming infinite supply of each coin, find the minimum number of coins required to form that value.
// ----------------------------------------------------------------------


public class MinCoinsForChange {

    public static int minCoins(int coins[], int val){
        int n = coins.length;

        // Arrays.sort(coins); // only if the given array is not sorted

        int i = n-1;
        int minCoins = 0;

        while(i >= 0){
            while(coins[i] <= val){
                val-=coins[i];
                minCoins+=1;
            }
            i--;
        }

        return minCoins;
    }
    
    public static void main(String args[]){
        int coins[] = {1,2,5,10,20,50,100,200,500,1000};
        int value = 49;

        System.out.println(minCoins(coins, value));
    }
}
