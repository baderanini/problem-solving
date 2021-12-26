class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqs = fillFreqs(t);
        
        int st = 0;
        int min = Integer.MAX_VALUE;
        int minSt = -1, minEnd = -1;
        
        int matches = 0;
        for(int end = 0 ; end < s.length() ; end++) {
            char curr = s.charAt(end);
            if(freqs.containsKey(curr)) {
                freqs.put(curr, freqs.get(curr) - 1);
                if(freqs.get(curr) == 0)
                     matches++;
            }
            
            while(matches == freqs.size() && st <= end) {
                char stChar = s.charAt(st);
                if(end - st + 1 < min) {
                    min = end - st + 1;
                    minSt = st;
                    minEnd = end;
                }
                if(freqs.containsKey(stChar)) {
                    freqs.put(stChar, freqs.get(stChar) + 1);
                    if(freqs.get(stChar) == 1)
                        matches--;
                }
                st++;
            }
        }
        
        
        if(minSt == -1)
            return "";
        return s.substring(minSt, minEnd+1);
    }
    
    
    Map<Character, Integer> fillFreqs(String s) {
        Map<Character, Integer> freqs = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char curr = s.charAt(i);
            freqs.put(curr, freqs.getOrDefault(curr, 0) + 1);
        }
        
        return freqs;
    }
    
}


/*


"ADOBECODEBANC"

DOBECODEBA

*/