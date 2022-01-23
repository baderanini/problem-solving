class Solution {
    final int LINE_START = 0, LINE_MIDDLE = 1, LINE_END = 2;
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        
        int state = LINE_START;
        int lineSize = 0, currWordPointer = 0;
        ArrayList lineWords = new ArrayList<>();
        while(currWordPointer <= words.length) {
            switch(state) {
                case LINE_START:
                    if(currWordPointer < words.length && words[currWordPointer].length() <= maxWidth) {
                        lineWords.add(words[currWordPointer]);
                        lineSize += words[currWordPointer].length();
                        currWordPointer++;
                    }
                    state = LINE_MIDDLE;
                    break;
                case LINE_MIDDLE:
                    if(currWordPointer < words.length && (words[currWordPointer].length() + 1) <= (maxWidth - lineSize)) {
                        lineWords.add(words[currWordPointer]);
                        lineSize += words[currWordPointer].length() + 1;
                        currWordPointer++;
                    } else
                        state = LINE_END;
                    break;
                case LINE_END:
                    lines.add(justifyLine(lineWords, lineSize, maxWidth, currWordPointer == words.length));
                    lineWords = new ArrayList<>();
                    lineSize = 0;
                    state = LINE_START;
                    if(currWordPointer == words.length)
                        return lines;
            }
        }
        
        return lines;
    }
    
    String justifyLine(ArrayList<String> words, int lineSize, int maxWidth, boolean lastLine) {
        int evenlyDistributedSpaces = (words.size() == 1 || lastLine) ? 0 : (maxWidth-lineSize)/(words.size()-1);
        int rightDistributedSpaces = (words.size() == 1 || lastLine) ? 0 : (maxWidth-lineSize)%(words.size()-1);
        StringBuilder justifiedSb = new StringBuilder();
        
        for(int i = 0 ; i < words.size() ; i++) {
            if(i != 0)
                justifiedSb.append(' ');    
            justifiedSb.append(words.get(i));
            if(i != words.size() - 1) {
                for(int j = 0 ; j < evenlyDistributedSpaces ; j++)
                    justifiedSb.append(' ');
            }
            if(rightDistributedSpaces > 0) {
                justifiedSb.append(' ');
                rightDistributedSpaces--;
            }
        }
        
        while(justifiedSb.length() < maxWidth)
            justifiedSb.append(' ');
        
        return justifiedSb.toString();
    }
}