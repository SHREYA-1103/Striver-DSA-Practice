// -------------------------------- Ques --------------------------------
// Given a 2D array of n intervals, with a starting point and an ending point for each of the intervals. Aim is to merge the overlapping intervals and return the minimal set of non-overlapping intervals.
// ----------------------------------------------------------------------


import java.util.*;

public class MergeIntervals {

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
    public static List<List<Integer>> mergedIntervals(int intervals[][]){
        int n = intervals.length;
        
        PriorityQueue<Interval> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        List<List<Integer>> list = new ArrayList<>();
        
        Interval i = pq.remove();
        int startTime = i.start;
        int endTime = i.end;

        List<Integer> l;
        
        while(!pq.isEmpty()){
            i = pq.remove();

            if(i.start >= startTime && i.start <= endTime){
                endTime = Math.max(endTime, i.end);
            }
            else{
                l = new ArrayList<>();
                l.add(startTime);
                l.add(endTime);
                list.add(l);
                startTime = i.start;
                endTime = i.end;
            }
        }

        l = new ArrayList<>();
        l.add(startTime);
        l.add(endTime);
        list.add(l);

        return list;
    }
    
    public static void main(String args[]){
        int intervals[][] = {{1,2},
                        {3,7},
                        {8,10},
                        {12,16},
                        {3,4}};

        System.out.println(mergedIntervals(intervals));
    }
}
