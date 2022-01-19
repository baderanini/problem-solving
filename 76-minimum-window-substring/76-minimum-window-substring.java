class Solution {
    public String minWindow(String s1, String s2) {
        int st = 0;
        
        Map<Character, Integer> requiredfreqs = findRequiredFreqs(s2);
        int matches = 0;
        int minWindow = Integer.MAX_VALUE, minWindowSt = -1;
        for(int end = 0 ; end < s1.length() ; end++) {
            char curr = s1.charAt(end);
            if(requiredfreqs.containsKey(curr)) {
                requiredfreqs.put(curr, requiredfreqs.get(curr) - 1);
                if(requiredfreqs.get(curr) == 0)
                    matches++;
            }
            
            while(matches == requiredfreqs.size() && st <= end) {
                if(end - st + 1 < minWindow) {
                    minWindow = end - st + 1;
                    minWindowSt = st;
                }
                
                char stChar = s1.charAt(st);
                if(requiredfreqs.containsKey(stChar)) {
                    requiredfreqs.put(stChar, requiredfreqs.get(stChar) + 1);
                if(requiredfreqs.get(stChar) == 1)
                    matches--;
                }
                st++;
            }
        }
        
        return minWindow == Integer.MAX_VALUE ? "" : s1.substring(minWindowSt, minWindowSt + minWindow);
    }
    
    Map<Character, Integer> findRequiredFreqs(String s) {
        Map<Character, Integer> freqs = new HashMap<>();
        for(char c: s.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }
        
        return freqs;
    }   
}