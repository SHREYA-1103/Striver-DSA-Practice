// -------------------------------- Ques --------------------------------
// Given an array of jumps, with jump[i] defining the max number of places a person can jump. Assuming the person to be starting from index 0, find if he can reach the last index, if yes, return true and false otherwise.
// ----------------------------------------------------------------------

public class JumpGame {

    // optimal - O(n), O(1)
    public static boolean canReachLast(int jump[]){
        int n = jump.length;

        int ind = 0;

        int maxInd = 0;

        while(ind < n){
            if(maxInd >= n-1) return true;
            if(maxInd < ind) return false;
            maxInd = Math.max(maxInd, jump[ind]+ind);
            ind++;
        }

        return maxInd >= n;
    }
    
    public static void main(String args[]){
        int jump[] = {1,2,3,1,1,0,2,5};

        System.out.println(canReachLast(jump));
    }
}
