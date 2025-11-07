// -------------------------------- Ques --------------------------------
// Given a rating array where rating[i] denotes the rating of the ith child. Find the minimum number of candies which are required to be distributed among the children such that the following conditions are satisfied: 
// -- Each child gets atleast one candy
// -- child with higher rating gets more candies than the neighbors  
// ----------------------------------------------------------------------


public class Candy {

    // better - O(n), O(n)
    public static int minCandies_better(int rating[]){
        int n = rating.length;

        int left[] = new int[n];

        left[0] = 1;

        for(int i=1; i<n; i++){
            if(rating[i] > rating[i-1]){
                left[i] = left[i-1] + 1;
            }
            else{
                left[i] = 1;
            }
        }

        int minCandies =  left[n-1];
        
        for(int i=n-2; i>=0; i--){
            if(rating[i] > rating[i+1]){
                left[i] = Math.max(left[i], left[i+1] + 1);
            }
            minCandies += left[i];
        }
        // one of approaches is to calculate right array the same way and then take the max of left[i] and right[i], but in the optimized version we can update the left array itself to avoid additional right array space.

        return minCandies;
    }

    // optimal - O(n), O(1)
    public static int minCandies_opt(int rating[]){
        int n = rating.length;

        int i = 1;
        int minCandies = 1;

        while(i < n){
            if(rating[i] == rating[i-1]){
                minCandies+=1;
                i++;
                continue;
            }

            int peak = 1;
            while(i < n && rating[i] > rating[i-1]){
                peak+=1;
                minCandies+=peak;
                i++;
            }

            int down = 1;
            while(i < n && rating[i] < rating[i-1]){
                minCandies+=down;
                i++;
                down++;
            }

            if(down > peak){
                minCandies += down-peak;
            }

        }

        return minCandies;
    }
    
    public static void main(String args[]){
        int rating[] = {0,2,4,3,2,1,1,3,5,6,4,0,0};

        System.out.println(minCandies_better(rating));
        System.out.println(minCandies_opt(rating));
    }
}
