// -------------------------------- Ques --------------------------------
// Given an array of jumps, with jump[i] defining the max number of places a person can jump. Assuming the person to be starting from index 0, find the min number of jump the person needs to take to reach the last index. Assume that the person can definitely reach the last index.
// ----------------------------------------------------------------------


public class JumpGameII {
    
    // Optimal - O(n), O(1)
    public static int minJumps(int jump[]){
        int n = jump.length;

        int left = 0, right = 0;

        int minJumps = 0;

        while(left < n){
            if(right >= n-1) return minJumps;
            if(jump[left]+left > right){
                right = jump[left]+left;
                minJumps++;
            }
            left++;
        }

        return minJumps;
    }
    
    public static void main(String args[]){
        int jump[] = {2,3,1,1,4};

        System.out.println(minJumps(jump));
    }
}
