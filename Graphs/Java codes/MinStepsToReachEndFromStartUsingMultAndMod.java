import java.util.*;

public class MinStepsToReachEndFromStartUsingMultAndMod {

    public static int minMultiplications(int[] arr, int start, int end) {

        int mod = 100000;

        // dist[num] = minimum steps to reach num
        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] info = q.remove();
            int num = info[0];
            int steps = info[1];

            if (num == end) return steps;

            for (int x : arr) {
                int nxt = (int)((long)num * x % mod);

                if (dist[nxt] > steps + 1) {
                    dist[nxt] = steps + 1;
                    q.add(new int[]{nxt, steps + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3, end = 30;

        System.out.println(minMultiplications(arr, start, end)); 
    }
}

