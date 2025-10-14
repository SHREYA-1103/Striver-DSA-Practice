public class RowWithMaxOnesInSortedBinaryMatrix {

    // optimal - O(log n), O(1)
    public static int findLowerBound(int arr[], int target){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int minIdx = n;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= target){
                high = mid-1;
                minIdx = Math.min(minIdx, mid);
            }
            else{
                low = mid+1;
            }
        }

        return minIdx;
    }
    
    public static int findRowIdx(int matrix[][]){
        int m = matrix.length; // rows count
        int n = matrix[0].length; // cols count

        int idx = 0;
        int max = 0;

        // count of ones in any row = length of row - lower bound of 1
        for(int i=0; i<n; i++){
            int countOnes = m - findLowerBound(matrix[i], 1);
            if(countOnes > max){
                max = countOnes;
                idx = i;
            }
        } 

        return idx;
    }
    
    public static void main(String args[]){
        int matrix[][] = {{0,0,1,1,1},
                        {0,0,0,0,0},
                        {0,1,1,1,1},
                        {0,0,0,0,0},
                        {0,1,1,1,1}};
        
        System.out.println(findRowIdx(matrix));
    }
}
