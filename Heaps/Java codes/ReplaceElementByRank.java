import java.util.*;

public class ReplaceElementByRank {

    public static class Info implements Comparable<Info>{
        int num;
        int idx;

        public Info(int n, int i){
            this.num = n;
            this.idx = i;
        }

        @Override
        public int compareTo(Info i2){
            return this.num - i2.num;
        }
    }

    public static List<Integer> getRank(int arr[]){
        int n = arr.length;

        List<Integer> res = new ArrayList<>();

        if(n == 0) return res;

        if(n == 1){
            res.add(1);
            return res;
        }
        
        PriorityQueue<Info> pq = new PriorityQueue<>(); // min heap

        for(int i=0; i<n; i++){
            res.add(0);
            pq.add(new Info(arr[i], i));
        }

        int rank = 0;
        int prev = Integer.MIN_VALUE;
        
        while(!pq.isEmpty()){
            Info curr = pq.remove();
            if(curr.num != prev){
                prev = curr.num;
                res.set(curr.idx, ++rank);
            }
            else{
                res.set(curr.idx, rank);
            }
            
        }

        return res;
    }
    
    public static void main(String args[]){
        int arr[] = {1, 5, 8, 15, 8, 25, 9};

        System.out.println(getRank(arr));
    }
}