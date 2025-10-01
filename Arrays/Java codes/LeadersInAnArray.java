import java.util.*;

public class LeadersInAnArray {

    // Better - O(2n), O(n)
    public static int[] findLeaders_better(int arr[]){
        List<Integer> list = new ArrayList<>();

        int n = arr.length;

        Stack<Integer> s = new Stack<>();

        list.add(arr[n-1]);
        s.push(arr[n-1]);

        for(int i=n-2; i>=0; i--){
            while(!s.isEmpty() && s.peek() < arr[i]) s.pop();
            if(s.isEmpty()) list.add(arr[i]);
            s.push(arr[i]);
        }

        int res[] = new int[list.size()];

        int idx = 0;

        for(int i=list.size()-1; i>=0; i--) res[idx++] = list.get(i);

        return res;
    }

    // optimal - O(n), O(1)
    public static int[] findLeaders_optimal(int arr[]){
        int n = arr.length;

        List<Integer> list = new ArrayList<>();

        list.add(arr[n-1]);
        int max = arr[n-1]; // to track max element till now from right

        for(int i=n-1; i>=0; i--){
            if(arr[i] > max){
                list.add(arr[i]);
                max = arr[i];
            }
        }

        int res[] = new int[list.size()];

        int idx = 0;

        for(int i=list.size()-1; i>=0; i--) res[idx++] = list.get(i);

        return res;
    }
    
    public static void main(String args[]){
        int arr[] = {10, 22, 12, 3, 0, 6};

        int leaders[] = findLeaders_optimal(arr);

        for(int l: leaders){
            System.out.print(l + " ");
        }
    }
}
