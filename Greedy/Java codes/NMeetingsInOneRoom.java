// -------------------------------- Ques --------------------------------
// Given two arrays, one stating the start time of a meeting and another stating the end time of a meeting. Assume there is only one meeting room available, find the maximum number of meetings that can be conducted in that room.
// ----------------------------------------------------------------------


import java.util.*;

public class NMeetingsInOneRoom {

    public static class Meet implements Comparable<Meet>{
        int start;
        int end;
        // can store the meeting id as well here to find the meetings that can be conducted

        public Meet(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Meet m2){
            return this.end - m2.end;
        }
    }

    // optimal - O(n log n), O(n)
    public static int maxMeetings(int start[], int end[]){
        int n = start.length;
        
        PriorityQueue<Meet> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(new Meet(start[i], end[i]));
        }

        int endTime = 0;
        int maxMeets = 0;

        while(!pq.isEmpty()){
            Meet m = pq.remove();

            if(m.start >= endTime){
                endTime = m.end;
                maxMeets++;
            }
        }

        return maxMeets;
    }
    
    public static void main(String args[]){
        int start[] = {0,3,1,5,5,8};
        int end[] = {5,4,2,9,7,9};

        System.out.println(maxMeetings(start, end));
    }
}
