class Solution {

    Random random;
    int[] w;
    int totalSum = 0;
    public Solution(int[] w) {
        random = new Random();
        for(int i = 1 ; i < w.length ; i++) {
            w[i] += w[i-1];
        }
        totalSum = w[w.length-1];
        this.w = w;
    }
    
    public int pickIndex() {
        int weightedIndex = random.nextInt(totalSum) + 1;
        return binarySearch(weightedIndex);
    }
    
    int binarySearch(int val) {
        int l = 0, h = w.length - 1;
        
        while(l <= h) {
            int mid = l + (h-l)/2;
            
            if(w[mid] >= val)
                h = mid-1;
            else
                l = mid+1;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
**/
