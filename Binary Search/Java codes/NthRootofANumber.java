public class NthRootofANumber{

    // bruteforce - O(m log n), O(1);
    public static int findNthRoot_brute(int m, int n){
        int res = -1;
        
        for(int i=1; i<m+1; i++){
            if(power(i,n) == m){
                return i;
            }
        }

        return res;
    }

    // optimal - O(log n), O(1) -- using matrix exponentiation
    public static int power(int i, int n){
        int res = 1;

        while(n > 0){
            // if the exponent is odd, multiply the result by current base
            if((n & 1) ==1){
                res *= i;
            } 
            // square the base
            i *= i;
            // divide exponent by 2
            n /= 2;
        }

        return res;
    }

    // optimal - O(log n), O(1)
    public static int findNthRoot_optimal(int m, int n){
        int res = -1;

        int low = 1;
        int high = m;

        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(power(mid, n) == m){
                return mid;
            }
            else if(power(mid, n) < m){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return res;
    }

    public static void main(String args[]){
        int m = 28;
        int n = 3;

        System.out.println(findNthRoot_brute(m, n));

        System.out.println(findNthRoot_optimal(m, n));
    }
}