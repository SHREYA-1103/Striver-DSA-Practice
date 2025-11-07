// -------------------------------- Ques --------------------------------
// Given two arrays of n trains, one stating the arrival time and other stating the departure time. Find the minimum number of platforms needed to schedule all the trains. Two trains can be scheduled on the same platform only if the first one has departed before the second one arrives.
// ----------------------------------------------------------------------


import java.util.*;

public class MinPlatformsForRailwayStation {

    // optimal - O(n log n), O(n)
    public static int minPlatforms(int arr[], int dep[]){
        int n = arr.length;
        
        Arrays.sort(arr);
        Arrays.sort(dep);

        int minPlatforms = 1;
        int platforms = 1;
        
        int i = 1;
        int j = 0;

        while(i < n && j < n){
            if(arr[i] <= dep[j]){ // next train arrives before the earliest departs
                platforms++;
                i++;
            }
            else{
                platforms--;
                j++;
            }
            minPlatforms = Math.max(platforms, minPlatforms);
        }

        return minPlatforms;
    }
    
    public static void main(String args[]){
        int arr[] = {900, 945, 955, 1100, 1500, 1800};
        int dep[] = {920, 1200, 1130, 1150, 1900, 2000};

        System.out.println(minPlatforms(arr, dep));
    }
}
