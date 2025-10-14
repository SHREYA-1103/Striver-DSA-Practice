public class PeakElementIn2DMatrix {

    public static int maxElementInCol(int[][] matrix, int colIdx){
        int m = matrix.length; // rows

        int max = -1;
        int res = 0;

        for(int i=0; i<m; i++){
            if(matrix[i][colIdx] > max){
                max = matrix[i][colIdx];
                res = i;
            }
        }

        return res;
    }

    // optimal - O(n log m), O(1)
    public static int findPeak(int matrix[][]){
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols
        
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            
            int row = maxElementInCol(matrix, mid);

            int leftCol = mid-1 >= 0 ? matrix[row][mid-1] : -1;
            int rightCol = mid+1 < m-1 ? matrix[row][mid+1] : -1;

            if(matrix[row][mid] > leftCol && matrix[row][mid] > rightCol) return matrix[row][mid];

            else if(matrix[row][mid] < leftCol) high = mid-1;

            else low = mid+1;
        }

        return -1;
    }
    
    public static void main(String args[]){
        int matrix[][] = {{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}};
        
        System.out.println(findPeak(matrix));
    }
}
