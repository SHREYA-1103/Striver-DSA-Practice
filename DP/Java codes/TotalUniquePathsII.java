public class TotalUniquePathsII {

    public static int countPaths_tab(int matrix[][]){
        int dp[][] = new int[if(i >= 0 && j >= 0 && matrix[i][j] == -1) return 0;

        if(i == 0 && j == 0) return 1;

        if(i == 0 || j == 0) return 0;


    }
    
    public static void main(String args[]){
        int matrix[][] = {{0,0,0}, {0,-1,0}, {0,0,0}};

        System.out.println(countPaths_tab(matrix));

        System.out.println(countPaths_so(matrix));
    }
}
