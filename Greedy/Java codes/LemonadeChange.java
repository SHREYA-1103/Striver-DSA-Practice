// ---------------------------------- Ques ------------------------------
// Given a number of customers with each providing one of the three denomination of money - 5/10/20 for a lemonade worth 5
// Find if all the customers can be served. All the customers can be served iff everyone pays can be returned the remaining balance.
// ----------------------------------------------------------------------


import java.util.*;

public class LemonadeChange {

    // Optimal  - O(n log n), O(1)
    public static boolean canSell(int[] customers){
        int n = customers.length;
        
        int five = 0;
        int ten = 0;
        int twenty = 0;

        Arrays.sort(customers);

        int i = 0;
        
        while(i < n){
            switch (customers[i]) {
                case 5 -> five++;
                case 10 -> {
                    ten++;
                    if(five > 0) five--;
                    else return false;
                }
                default -> {
                    twenty++;
                    if(ten > 0 && five > 0){
                        ten--; five--;
                    }
                    else if(five > 2) five-=3;
                    else return false;
                }
            }
        }

        return true;
    }
    
    public static void main(String args[]){
        int customers[] = {5,5,5,10,20}; // amount paid by the customers

        System.out.println(canSell(customers));
    }
}
