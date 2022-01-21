class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] lSums = new int[k+1];
        int[] rSums = new int[k+1];
        
        int l = 0, r = cardPoints.length - 1;
        while(l < k) {
            lSums[l+1] = cardPoints[l] + lSums[l];
            rSums[r - cardPoints.length + k] = cardPoints[r] + rSums[r - cardPoints.length + k + 1];
            l++;
            r--;
        }
        
        int result = 0;
        for(int i = 0 ; i <= k ; i++) {
            result = Math.max(result, lSums[i] + rSums[i]);
        }
        
        return result;
    }
}