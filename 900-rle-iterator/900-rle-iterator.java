class RLEIterator {

    int[] encoding;
    int index = 0;
    int lastIndex = 0;
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.lastIndex = preprocess(encoding);
    }
    
    public int next(int n) {
        while(index <= lastIndex) {
            int currCount = encoding[index];
            int currNum = encoding[index+1];
            
            if(currCount >= n) {
                encoding[index] -= n;
                return currNum;
            } else {
                n -= currCount;
                index +=2;
            }
        }
        return -1;
    }
    
    int preprocess(int[] encoding) {
        int writeIndex = 0;
        
        for(int i = 2 ; i < encoding.length ; i+=2) {
            int currNum = encoding[i+1], prevNum = encoding[i-1];
            int currCount = encoding[i];
            if(currCount > 0) {
                if(currNum == prevNum)
                    encoding[writeIndex]+=currCount;
                else {
                    writeIndex+=2;
                    encoding[writeIndex] = currCount;
                    encoding[writeIndex+1] = currNum;
                }
                    
            }
        }
        
        return writeIndex;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */