// -------------------------------- Ques --------------------------------
// Given a 2D array of n intervals, with a starting point and an ending point for each of the interval, find the max number of non-overlapping intervals. interval[i] and interval[j] are said to be overlapping if interval[j][0] > interval[i][0] and interval[j][0] < interval[i][1].
// ----------------------------------------------------------------------


import java.util.*;

public class NonOverlappingIntervals {

    public static class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Interval i2){
            return this.start - i2.start;
        }
    }

    // optimal - O(n log n), O(n)
    public static int maxNonOverlappingIntervals(int intervals[][]){
        int n = intervals.length;
        
        PriorityQueue<Interval> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        int maxIntervals = 0;

        Interval i = pq.remove();
        int startTime = i.start;
        int endTime = i.end;

        while(!pq.isEmpty()){
            i = pq.remove();

            if(i.start > startTime && i.start < endTime){
                endTime = Math.max(endTime, i.end);
            }
            else{
                maxIntervals++;
                startTime = i.start;
                endTime = i.end;
            }
        }

        return maxIntervals;
    }
    
    public static void main(String args[]){
        int intervals[][] = {{1,2},
                        {2,3},
                        {3,4},
                        {1,3}};

        System.out.println(maxNonOverlappingIntervals(intervals));
    }
}
