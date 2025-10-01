public class SquareRoot{

    // bruteforce - O(n), O(1);
    public static int findSqrt_brute(int num){
        int res = -1;
        
        for(int i=1; i<num+1; i++){
            if(i*i <= num){
                res = Math.max(res, i);
            }
            else{
                break;
            }
        }

        return res;
    }

    // optimal - O(log n), O(1)
    public static int findSqrt_optimal(int num){
        int res = -1;

        int low = 1;
        int high = num;

        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(mid*mid <= num){
                res = Math.max(res, mid); // need not store, at the end - high is answer
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return res;
    }

    public static void main(String args[]){
        int num = 10;

        System.out.println(findSqrt_brute(num));

        System.out.println(findSqrt_optimal(num));
    }
}