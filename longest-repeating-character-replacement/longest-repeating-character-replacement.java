class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFreqs = new int[26];
        
        int st = 0;
        int max = 0;
        
        for(int end = 0 ; end < s.length() ; end++) {
            char currChar = s.charAt(end);
            charFreqs[currChar - 'A']++;
            
            while(end - st + 1 - currMaxFreqOfChar(charFreqs) > k) {
                char stChar = s.charAt(st);
                charFreqs[stChar - 'A']--;
                st++;
            }
            
            max = Math.max(max, end - st + 1);
        }
        
        return max;
    }
    
    int currMaxFreqOfChar(int[] charFreqs) {
        int max = 0;
        
        for(int i = 0 ; i < charFreqs.length ; i++) {
            max = Math.max(max, charFreqs[i]);
        }
        
        return max;
    }
}