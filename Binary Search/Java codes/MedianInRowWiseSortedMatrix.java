public class MedianInRowWiseSortedMatrix {

    // optimal - O(log n), O(1)
    public static int findUpperBound(int arr[], int target){
        int n = arr.length;

        int low = 0;
        int high = n-1;

        int minIdx = n;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] > target){
                high = mid-1;
                minIdx = Math.min(minIdx, mid);
            }
            else{
                low = mid+1;
            }
        }

        return minIdx;
    }

    public static int count(int matrix[][], int val){
        int m = matrix.length; // rows

        int count = 0;

        for(int i=0; i<m; i++){
            count+= findUpperBound(matrix[i], val);
        }

        return count;
    }

    // optimal - O(n log^n)
    public static int findMedian(int matrix[][]){
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols

        int low = matrix[0][0];
        int high = matrix[m-1][n-1];

        int k = m*n/2;

        while(low <= high){
            int mid = low + (high - low)/2;

            int smallerAndEqual = count(matrix, mid);

            if(smallerAndEqual <= k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return low;
    }
    
    public static void main(String args[]){
        int matrix[][] = {{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}}; // always given a matrix of odd number of elements
        
        System.out.println(findMedian(matrix));
    }
}
