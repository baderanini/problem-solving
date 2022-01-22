class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> seqLengthsUntil = new HashMap<>();
        
        int max = 0;
        for(int num: arr) {
            int seqBefore = seqLengthsUntil.getOrDefault(num - difference, 0);
            seqLengthsUntil.put(num, Math.max(seqLengthsUntil.getOrDefault(num, 0), 1 + seqBefore));
            max = Math.max(max, 1 + seqBefore);
        }
        
        return max;
    }
}