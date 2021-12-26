class Solution {
    public String minWindow(String s, String t) {
        int[] freqs = new int[52];
        int uniqueChars = fillFreqs(t, freqs);
        
        int st = 0;
        int min = Integer.MAX_VALUE;
        int minSt = -1, minEnd = -1;
        
        int matches = 0;
        for(int end = 0 ; end < s.length() ; end++) {
            char curr = s.charAt(end);
            if(freqs[cIndex(curr)] != Integer.MIN_VALUE) {
                freqs[cIndex(curr)]--;
                if(freqs[cIndex(curr)] == 0)
                     matches++;
            }
            
            while(matches == uniqueChars && st <= end) {
                char stChar = s.charAt(st);
                if(end - st + 1 < min) {
                    min = end - st + 1;
                    minSt = st;
                    minEnd = end;
                }
                if(freqs[cIndex(stChar)] != Integer.MIN_VALUE) {
                    
                    freqs[cIndex(stChar)]++;
                    if(freqs[cIndex(stChar)] == 1)
                        matches--;
                }
                st++;
            }
        }
        
        
        if(minSt == -1)
            return "";
        return s.substring(minSt, minEnd+1);
    }
    
    
    int fillFreqs(String s, int[] freqs) {
        
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            char curr = s.charAt(i);
            if(freqs[cIndex(curr)] == 0)
                count++;
            freqs[cIndex(curr)]++;
        }
        
        for(int i = 0 ; i < 52 ; i++) {
            if(freqs[i] == 0)
                freqs[i] = Integer.MIN_VALUE;
        }
        
        return count;
    }
    
    int cIndex(char c) {
        if(c - 'A' < 26)
            return c - 'A' + 26;
        else
            return c - 'a';
    }
    
}


/*


"ADOBECODEBANC"

DOBECODEBA

*/