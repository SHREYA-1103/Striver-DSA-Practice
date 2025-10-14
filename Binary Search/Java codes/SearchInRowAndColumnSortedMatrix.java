public class SearchInRowAndColumnSortedMatrix {

    // optimal - O(m+n), O(1)
    public static boolean search(int matrix[][], int key){
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols

        int row = 0;
        int col = n-1;

        while(!(row == m-1 && col == 0)){
            int curr = matrix[row][col];
            
            if(curr == key) return true;

            else if(curr < key){
                if(row < m-1) row++;
                else return false;
            }

            else{
                if(col > 0) col--;
                else return false;
            }
        }

        return false;
    }
    
    public static void main(String args[]){
        int matrix[][] = {{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}};

        int key = 20;

        System.out.println(search(matrix, key));
    }
}
