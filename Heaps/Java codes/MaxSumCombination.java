import java.util.*;

public class MaxSumCombination {

    public static class Pair implements Comparable<Pair>{
        int sum;
        int i;
        int j;

        public Pair(int s, int i, int j){
            this.sum = s;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.sum - this.sum;
        }
    }

    public static List<Integer> maxSums(int nums1[], int nums2[], int k){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashSet<String> vis = new HashSet<>();

        List<Integer> res = new ArrayList<>();

        int m = nums1.length;
        int n = nums2.length;

        pq.add(new Pair(nums1[m-1] + nums2[n-1], m-1, n-1));
        vis.add(""+(m-1)+"#"+(n-1));

        while(k-- > 0 && !pq.isEmpty()){
            Pair p = pq.remove();
            
            int sum = p.sum;
            int i = p.i;
            int j = p.j;
            
            res.add(sum);

            String str1 = "" + (i-1) + "#" + (j);
            String str2 = "" + (i) + "#" + (j-1);
            
            if(i > 0 && !vis.contains(str1)){
                pq.add(new Pair(nums1[i-1] + nums2[j], i-1, j));
            }

            if(j > 0 && !vis.contains(str2)){
                pq.add(new Pair(nums1[i] + nums2[j-1], i, j-1));
            }
        }

        return res;
    }
    
    public static void main(String args[]){
        int nums1[] = {7,3};
        int nums2[] = {1,6};

        int k = 2;

        System.out.println(maxSums(nums1, nums2, k));
    }
}
