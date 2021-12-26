class Solution {
    public List<Integer> findSubstring(String s, String[] wordsArr) {
        Map<String, Integer> words = fillWords(wordsArr);
        
        
        
        List<Integer> res = new ArrayList<>();
        int sSize = s.length();
        int wordCount = wordsArr.length;
        int wordSize = wordsArr[0].length();
        int windowSize = wordCount * wordSize;
        for(int i = 0 ; i <= sSize - windowSize ; i++) {
            Map<String, Integer> myWords = new HashMap<>(words);
                int matches = 0;
                for(int j = 0 ; j < wordCount ; j++) {
                    int stIndex = i + j * wordSize;
                    int endIndex = stIndex + wordSize;
                    String currWord = s.substring(stIndex, endIndex);
                    if(!myWords.containsKey(currWord) || myWords.get(currWord) == 0)
                        break;
                    myWords.put(currWord, myWords.get(currWord) - 1);
                    if(myWords.get(currWord) == 0)
                        matches++;
                }
                if(matches == myWords.size())
                    res.add(i);
        }    
        
        return res;
    }
    
    Map<String, Integer> fillWords(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        return map;
    }
}