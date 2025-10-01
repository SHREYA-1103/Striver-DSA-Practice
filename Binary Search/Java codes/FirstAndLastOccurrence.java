public class FirstAndLastOccurrence {

    // bruteforce - O(n), O(1)
    public static int[] findFirstAndLast_brute(int arr[], int m){
        int n = arr.length;

        int res[] = {-1, -1};

        for(int i=0; i<n; i++){
            if(arr[i] == m){
                res[0] = res[0] == -1 ? i : res[0];
                res[1] = i;
            }
        }

        return res;
    }

    // optimal - O(2 log n), O(1)
    public static int[] findFirstAndLast_optimal(int arr[], int m){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int res[] = {-1, -1};

        // find first occurrence
        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == m){
                res[0] = mid;
                high = mid-1;
            }

            else if(arr[mid] < m){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        low = 0;
        high = n-1;

        // find last occurrence
        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == m){
                res[1] = mid;
                low = mid+1;
            }

            else if(arr[mid] < m){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return res;
    }
    
    public static void main(String args[]){
        int arr[] = {2,4,6,8,8,8,11,13};
        int m = 8;

        int res1[] = findFirstAndLast_brute(arr, m);

        System.out.println("First occurrence: " + res1[0]);
        System.out.println("Last occurrence: " + res1[1]);

        int res2[] = findFirstAndLast_optimal(arr, m);

        System.out.println("First occurrence: " + res2[0]);
        System.out.println("Last occurrence: " + res2[1]);

    }
}
