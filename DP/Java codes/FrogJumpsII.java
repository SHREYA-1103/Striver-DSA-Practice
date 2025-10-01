public class FrogJumpsII {

    public static int minEnergy_rec(int heights[], int k){

    }

    public static int minEnergy_memo(int heights[], int k){

    }

    public static int minEnergy_tab(int heights[], int k){

    }
    
    public static void main(String args){
        int heights[] = {2,3,1,4,3};
        int k = 3;

        System.out.println(minEnergy_rec(heights, k));

        int dp[] = new int[heights.length];
        System.out.println(minEnergy_memo(heights, k));

        System.out.println(minEnergy_tab(heights, k));
    }
}
