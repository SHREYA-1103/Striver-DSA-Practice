import java.util.*;

public class NinjaTraining {

    //bruteforce (recursion) - O(2^4n), O(2*4n)
    public static int countPoints_rec(int tasks[][], int day, int last){
        if(day == 0){
            int max = 0;
            for(int i=0; i<3; i++){
                if(i != last){
                    max = Math.max(max, tasks[0][i]);
                }
            }

            return max;
        }

        int max = 0;

        for(int i=0; i<3; i++){
            if(i != last){
                int points = tasks[day][i] + countPoints_rec(tasks, day-1, i);
                max = Math.max(max, points);
            }
        }

        return max;
    }

    // better (DP memoization) - O(12n), O(5n)
    public static int countPoints_memo(int tasks[][], int day, int last, int dp[][]){
        if(day == 0){
            int max = 0;
            for(int i=0; i<3; i++){
                if(i != last){
                    max = Math.max(max, tasks[0][i]);
                }
            }

            return dp[day][last] = max;
        }

        if(dp[day][last] != -1) return dp[day][last];

        int max = 0;

        for(int i=0; i<3; i++){
            if(i != last){
                int points = tasks[day][i] + countPoints_memo(tasks, day-1, i, dp);
                max = Math.max(max, points);
            }
        }

        return dp[day][last] = max;
    }

    // optimal1 (DP tabulation) - O(12n), O(4n)
    public static int countPoints_tab(int tasks[][]){
        int dp[][] = new int[tasks.length][4];

        dp[0][0] = Math.max(tasks[0][1], tasks[0][2]);
        dp[0][1] = Math.max(tasks[0][0], tasks[0][2]);
        dp[0][2] = Math.max(tasks[0][0], tasks[0][1]);
        dp[0][3] = Math.max(Math.max(tasks[0][0], tasks[0][1]), tasks[0][2]);

        for(int day=1; day<tasks.length; day++){
            for(int last=0; last<4; last++){
                dp[day][last] = 0;
                for(int task=0; task<3; task++){
                    if(task != last){
                        int point = tasks[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[tasks.length-1][3];
    }

    // optimal2 (DP tabulation space optimized) - O(12n), O(1)
    public static int countPoints_so(int tasks[][]){
        int dp[] = new int[4];

        dp[0] = Math.max(tasks[0][1], tasks[0][2]);
        dp[1] = Math.max(tasks[0][0], tasks[0][2]);
        dp[2] = Math.max(tasks[0][0], tasks[0][1]);
        dp[3] = Math.max(Math.max(tasks[0][0], tasks[0][1]), tasks[0][2]);

        for(int day=1; day<tasks.length; day++){
            int temp[] = new int[4];
            for(int last=0; last<4; last++){
                temp[last] = 0;
                for(int task=0; task<3; task++){
                    if(task != last){
                        temp[last] = Math.max(temp[last], tasks[day][task]+ dp[task]);
                    }
                }
            }
            dp = temp;
        }

        return dp[3];
    }
    
    public static void main(String args[]){
        int tasks[][] = {{10, 11, 19}, {4, 13, 7}, {1, 8, 13}};

        System.out.println(countPoints_rec(tasks, tasks.length-1, 3));
        
        int dp[][] = new int[tasks.length][4];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        System.out.println(countPoints_memo(tasks, tasks.length-1, 3, dp));

        System.out.println(countPoints_tab(tasks));

        System.out.println(countPoints_so(tasks));
    }
}
