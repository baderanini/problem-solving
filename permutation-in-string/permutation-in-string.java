class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int st = 0;
        Map<Character, Integer> patternFreqs = fillFreqs(s1);
        Map<Character, Integer> stringFreqs = new HashMap<>(patternFreqs);
        
        int matches = 0;
        for(int end = 0 ; end < s2.length() ; end++) {
            char curr = s2.charAt(end);
            
            if(!patternFreqs.containsKey(curr)) {
                matches = 0;
                st = end+1;
                stringFreqs = new HashMap<>(patternFreqs);
            } else {
                stringFreqs.put(curr, stringFreqs.get(curr) - 1);
                if(stringFreqs.get(curr) == 0)
                    matches++;
                else if(stringFreqs.get(curr) == -1)
                    matches--;
                if(end - st + 1 == s1.length()) {
                    if(matches == patternFreqs.size())
                        return true;
                    char stChar = s2.charAt(st);
                    stringFreqs.put(stChar, stringFreqs.get(stChar) + 1);
                    if(stringFreqs.get(stChar) == 0)
                        matches++;
                    else if(stringFreqs.get(stChar) == 1)
                        matches--;
                    st++;
                }
            }
        }
        
        return false;
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

"ab"
"eidbaooo"


*/

