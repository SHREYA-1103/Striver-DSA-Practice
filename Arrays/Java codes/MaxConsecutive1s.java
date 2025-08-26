public class MaxConsecutive1s {
    
    // Optimal - O(n), O(1)
    public static int count1s(int arr[]){
        int max = Integer.MIN_VALUE;
        
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1){
                count++;
            }
            if(arr[i] == 0){
                max = Math.max(max, count);
                count = 0;
            }
        }

        return max;
    }

    public static void main(String args[]){
        int arr[] = {1, 0, 1, 1, 1, 0, 0, 1, 1};

        System.out.println("Max length of consecutive 1's: " + count1s(arr));
    }
}
