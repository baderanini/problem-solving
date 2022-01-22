class SingleChar {
    char c;
    int index;
    
    SingleChar(char c, int index) {
        this.c = c;
        this.index = index;
    }
}

class Solution {
    public boolean canTransform(String start, String end) {
        int p1 = 0, p2 = 0;
        
        while(p1 < start.length() && p2 < end.length()) {
            while(p1 < start.length() && start.charAt(p1) == 'X')
                p1++;
            while(p2 < end.length() && end.charAt(p2) == 'X')
                p2++;
            
            if(p1 < start.length() && p2 < end.length()) {
                if(start.charAt(p1) != end.charAt(p2))
                    return false;
                if(start.charAt(p1) == 'L' && p2 > p1)
                    return false;
                if(start.charAt(p1) == 'R' && p1 > p2)
                    return false;
                p1++;
                p2++;
            }
        }
        
        while(p1 < start.length()) {
            if(start.charAt(p1++) != 'X')
                return false;
        }
        
        while(p2 < end.length()) {
            if(end.charAt(p2++) != 'X')
                return false;
        }
        
        return true;
    }
}