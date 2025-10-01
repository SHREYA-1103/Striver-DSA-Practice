import java.util.*;

public class TaskScheduler {

    static class Pair {
        int freq;
        int nextTime;

        public Pair(int f, int t){
            this.freq = f;
            this.nextTime = t;
        }
    }

    public static int minTime(char tasks[], int n){
        // count frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // max heap of frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : map.values()) {
            pq.add(f);
        }

        // cooldown queue
        Queue<Pair> cooldown = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int curr = pq.poll();
                if (curr - 1 > 0) {
                    cooldown.add(new Pair(curr - 1, time + n));
                }
            }

            if (!cooldown.isEmpty() && cooldown.peek().nextTime == time) {
                pq.add(cooldown.poll().freq);
            }
        }

        return time;
    }

    public static void main(String args[]) {
        char tasks[] = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(minTime(tasks, n)); // Output: 8
    }
}
