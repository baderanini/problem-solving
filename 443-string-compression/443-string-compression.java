class Solution {
    public int compress(char[] chars) {
        int writePointer = 0, counter = 1;
        for(int i = 1 ; i < chars.length ; i++) {
            if(chars[i] != chars[i-1]) {
                writePointer = writeBack(chars, writePointer, chars[i-1], counter);
                counter = 0;
            }
            counter++;
        }
        
        return Math.min(chars.length, writeBack(chars, writePointer, chars[chars.length-1], counter));
    }
    
    int writeBack(char[] chars, int writePointer, char c, int counter) {    
        write(c, writePointer++, chars);
        
        if(counter == 1) {
            return writePointer;
        }
        
        int count = 0;
        int tmpCounter = counter;
        while(counter > 0) {
            int digit = counter % 10;
            counter /= 10;
            count++;
        }
        
        counter = tmpCounter; 
        int endWritePos = writePointer + count - 1;
        while(counter > 0) {
            int digit = counter % 10;
            write((char) (digit+'0'), endWritePos--, chars);
            counter /= 10;
        }
        
        return writePointer + count;
    }
    
    void write(char c, int i, char[] chars) {
        if(i < chars.length) {
            chars[i] = c;
        }
    }
}


/*

4
. . (.) . . .

*/