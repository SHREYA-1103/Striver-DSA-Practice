import java.util.*;

public class TopKFrequentElements {

    public static class Pair implements Comparable<Pair>{
        int num;
        int freq;

        public Pair(int n, int f){
            this.num = n;
            this.freq = f;
        }

        @Override
        public int compareTo(Pair p2){
            return this.freq - p2.freq; // ascending order
        }
    }

    public static List<Integer> topKFrequent(int nums[], int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int num: map.keySet()){
            pq.add(new Pair(num, map.get(num)));
            if(pq.size() > k) pq.remove();
        }

        while(k-- > 0 && !pq.isEmpty()){
            res.add(pq.remove().num);
        }

        return res;
    }
    
    public static void main(String args[]){
        int nums[] = {4,4,6,6,7};
        int k = 2;

        System.out.println(topKFrequent(nums, k));
    }
}
