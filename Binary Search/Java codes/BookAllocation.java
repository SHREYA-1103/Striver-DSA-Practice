public class BookAllocation {

    public static int findStudents(int[] books, int maxPages){
        int count = 1;
        int currPages = 0;

        for (int pages : books) {
            if (pages > maxPages)
                return Integer.MAX_VALUE; // not possible if a single book > maxPages

            if (currPages + pages <= maxPages) {
                currPages += pages;
            } else {
                count++;
                currPages = pages;
            }
        }

        return count;
    }
    
    // optimal - O(n log(sum of pages))
    public static int minMaxPages(int books[], int students){
        int n = books.length;

        if(n < students){
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max, books[i]);
            sum += books[i];
        }

        int low = max;
        int high = sum;

        int res = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(findStudents(books, mid) == students){
                res = mid;
                high = mid-1; // find even smaller possible min
            }
            else if(findStudents(books, mid) < students){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return res;
    }
    
    public static void main(String args[]){
        int books[] = {25, 46, 28, 49, 24};
        int students = 4;

        System.out.println(minMaxPages(books, students));
    }
}
