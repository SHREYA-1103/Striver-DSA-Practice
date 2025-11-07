// -----------------------------------  Ques ----------------------------
// Given n cookies satisfying <=cookies[i] greed and greeds of m children denoted by geed[i], find the maximum no. of children which can be satisfied.
// For a child with greed[i], he has to be given a cookie such that cookie[i] >= greed[i]
// ----------------------------------------------------------------------


import java.util.*;

public class AssignCookies {

    // optimal - O(n log n), O(1)
    public static int maxChildrenSatisfied(int greed[], int cookies[]){
        int res = 0;

        Arrays.sort(greed);
        Arrays.sort(cookies);

        int i = 0;
        int j = 0;

        while(j < cookies.length){
            if(greed[i] <= cookies[j]){ 
                i++; j++;
                res++;
            }
            else j++;
        }

        return res;
    }
    
    public static void main(String args[]){
        int greed[] = {1, 5, 3, 3, 4};
        int cookies[] = {4, 2, 1, 2, 1, 3};

        System.out.println(maxChildrenSatisfied(greed, cookies));
    }
}
