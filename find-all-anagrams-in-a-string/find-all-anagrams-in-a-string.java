class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> res = new ArrayList<>();
        
        int st = 0;
        int[] patternFreqs = new int[26];
        int uniqueChars = fillFreqs(s1, patternFreqs);
        
        int matches = 0;
        for(int end = 0 ; end < s2.length() ; end++) {
            char curr = s2.charAt(end);
            
            if(patternFreqs[cIndex(curr)] == Integer.MIN_VALUE) {
                matches = 0;
                while(st < end+1) {
                    char stChar = s2.charAt(st);
                    if(patternFreqs[cIndex(stChar)] != Integer.MIN_VALUE) {
                        patternFreqs[cIndex(stChar)]++;
                    }
                    st++;
                }
            } else {
                patternFreqs[cIndex(curr)]--;
                if(patternFreqs[cIndex(curr)] == 0)
                    matches++;
                else if(patternFreqs[cIndex(curr)] == -1)
                    matches--;
                if(end - st + 1 == s1.length()) {
                    if(matches == uniqueChars)
                        res.add(st);
                    char stChar = s2.charAt(st);
                    patternFreqs[cIndex(stChar)]++;
                    if(patternFreqs[cIndex(stChar)] == 0)
                        matches++;
                    else if(patternFreqs[cIndex(stChar)] == 1)
                        matches--;
                    st++;
                }
            }
        }
        return res;
    }
    
    
    int cIndex(char c) {
        return c - 'a';
    }
    
    int fillFreqs(String s, int[] freqs) {
        int uniqueChars = 0;
        
        for(int i = 0 ; i < s.length() ; i++) {
            char curr = s.charAt(i);
            if(freqs[cIndex(curr)] == 0)
                uniqueChars++;
            freqs[cIndex(curr)]++;
        }
        
        for(int i = 0  ; i < 26 ; i++) {
            if(freqs[i] == 0)
             freqs[i] = Integer.MIN_VALUE;
        }
        
        return uniqueChars;
    }
}
