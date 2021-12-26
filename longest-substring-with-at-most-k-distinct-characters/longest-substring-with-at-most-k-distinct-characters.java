class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int st = 0;
        int max = 0;
        
        Map<Character, Integer> charFreqs = new HashMap<>();
        
        for(int end = 0 ; end < s.length() ; end++) {
            char currChar = s.charAt(end);
            charFreqs.put(currChar, charFreqs.getOrDefault(currChar, 0) + 1);
            
            while(charFreqs.size() > k) {
                char stChar = s.charAt(st);
                if(charFreqs.get(stChar) == 1)
                    charFreqs.remove(stChar);
                else
                    charFreqs.put(stChar, charFreqs.get(stChar) - 1);
                st++;
            }
            
            max = Math.max(max, end - st + 1);
        }
        
        return max;
    } 
}