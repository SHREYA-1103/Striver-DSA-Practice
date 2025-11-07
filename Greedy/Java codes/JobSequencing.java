// -------------------------------- Ques --------------------------------
// Given an array of n jobs with job[i][0] stating the deadline within which the job should be performed and job[i][1] stating the profit which can be earned by completing that job. Assume every job take 1 unit time, find the max profit which can be earned.
// ----------------------------------------------------------------------


import java.util.*;

public class JobSequencing {

    public static class Job implements Comparable<Job>{
        int deadline;
        int profit;

        public Job(int d, int p){
            this.deadline = d;
            this.profit = p;
        }

        @Override
        public int compareTo(Job j2){
            return j2.profit - this.profit;
        }
    }

    // better - O(n*maxDeadline), O(n)
    public static int maxProfits(int job[][]){
        int n = job.length;
        
        PriorityQueue<Job> pq = new PriorityQueue<>();

        int maxDeadline = 0;

        for(int i=0; i<n; i++){
            pq.add(new Job(job[i][0], job[i][1]));
            maxDeadline = Math.max(maxDeadline, job[i][0]);
        }

        boolean time[] = new boolean[maxDeadline];

        int maxProfit = 0;

        while(!pq.isEmpty()){
            Job j = pq.remove();

            for(int i=j.deadline-1; i>=0; i--){
                if(!time[i]){
                    time[i] = true;
                    maxProfit+=j.profit;
                    break;
                }
            }
        }

        return maxProfit;
    }

    // optimal - using Disjoint Set Union - to avoid inner loop
    
    public static void main(String args[]){
        int job[][] = {{2,80},
                        {6,70},
                        {6,65},
                        {5,60},
                        {4,25},
                        {2,22},
                        {4,20},
                        {2,10}};

        System.out.println(maxProfits(job));
    }
}
