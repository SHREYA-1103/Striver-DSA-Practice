
public class FindMissingNumber {

    public static int findMissing_xor(int arr[]){
        int n = arr.length+1;

        int xor1 = 0;
        int xor2 = 0;
        
        for(int i=1; i<n; i++){
            xor1 = xor1 ^ arr[i-1];
            xor2 = xor2 ^ i;
        }

        xor2 = xor2 ^ n;

        return xor1 ^ xor2;
    }

    public static int findMissing_sum(int arr[]){
        int n = arr.length+1;

        int sum1 = 0;
        int sum2 = 0;
        
        for(int i=1; i<n; i++){
            sum1 = sum1 + arr[i-1];
            sum2 = sum2 + i;
        }

        sum2 = sum2 + n;

        return sum2 - sum1;
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,5,4};

        System.out.println(findMissing_sum(arr));
    }
}
