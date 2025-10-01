import java.util.*;

public class MinCostToConnectNRopes {

    public static int minCost(int ropes[]){
        int n = ropes.length;

        if(n==0) return 0;

        if(n == 1) return ropes[0];

        if(n ==2) return ropes[0] + ropes[1];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(ropes[i]);
        }

        int cost = 0;

        while(pq.size() > 1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }

        return cost;
    }
    
    public static void main(String args[]){
        int ropes[] = {2,4,3};

        System.out.println(minCost(ropes));
    }
}
