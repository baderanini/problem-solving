class Solution {
    public String frequencySort(String s) {
        
        int[] freqs = fillFreqs(s);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(freqs[y], freqs[x]));
        
        
        for(int i = 0 ; i < freqs.length ; i++) {
            if(freqs[i] != 0)
                pq.offer(i);
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int c = pq.poll();
            int cFreq = freqs[c];
            for(int i = 0 ; i < cFreq ; i++) {
                sb.append((indexToChar(c)));
            }
        }
        
        return sb.toString();
    }
    
    char indexToChar(int index) {
            if(index < 26)
                return (char) (index + 'a');
            else if(index < 52)
                return (char) (index + 'A' - 26);
            else
                return (char) (index + '0' - 52);
        }
    
    int charIndex(char c) {
        if(Character.isDigit(c))
            return c - '0' + 52;
        if(c - 'a' >= 0)
            return c - 'a';
        else
            return c - 'A' + 26;
    }
    
    
    int[] fillFreqs(String s) {
        int[] freqs = new int[62];
        for(int i = 0 ; i < s.length() ; i++) {
            freqs[charIndex(s.charAt(i))]++;
        }
        
        return freqs;
    }
}